package com.prism.springas.controller.oAuth2;

import com.alibaba.fastjson.JSON;
import com.prism.springas.api.BaseApi;
import com.prism.springas.schema.BaseSchema;
import com.prism.springas.schema.exPand.SysUserExSchema;
import com.prism.springas.tools.IPTool;
import com.prism.springas.tools.MD5Tool;
import com.prism.springas.utils.BasePage;
import com.prism.springas.utils.http.SessionUtil;
import com.prism.springas.utils.oAuth2.oAuthToken;
import com.prism.springas.utils.sqlEngine.sqlEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class LoginOAuthController {

    @Autowired
    BaseSchema baseSchema;
    @Autowired
    SysUserExSchema sysUserExSchema;
    @Autowired
    BaseApi baseApi;
    @Autowired
    IPTool ipTool;
    @Autowired
    MD5Tool md5Tool;
    @Autowired
    com.prism.springas.utils.redis.jedisUtil jedisUtil;

    private final Logger logger = LoggerFactory.getLogger(LoginOAuthController.class);

    @Value("${configBasic.logoutUrl.url}")
    private String logoutUrl;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public String loginAdmin(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "userPwd") String userPwd) throws Exception {
        sqlEngine sqlEngine = new sqlEngine();
        sqlEngine.getSelTable("SYSUSER")
                .getSelCols("SYSUSER")
                .getWhereAnd("SYSUSER_EMAIL", "EQ", userName)
                .getWhereAnd("SYSUSER_PASSWORD", "EQ", userPwd);
        List<BasePage> userList = baseApi.selectPage("SYSUSER", sqlEngine);
        oAuthToken oAuthToken = new oAuthToken(request, response);
        Map result = new HashMap();
        Integer loginType = 0;//失败
        if (userList.size() > 0) {
            BasePage user = userList.get(0);
            if (Integer.parseInt(user.get("SYSUSER_ISDELETE") + "") == 0) {
                user.put("SYSUSER_NAME", user.get("SYSUSER_NAME"));
                this.sessionToken(oAuthToken, user.get("SYSUSER_NAME") + "", request, user);
                loginType = 1;
                sqlEngine router = new sqlEngine();
                router.getParamEx("uid",user.get("SYSUSER_ID"));
                result.put("router",sysUserExSchema.getRouter("sysUser",router));
                result.put("user",user.get("SYSUSER_NAME"));
                result.put("singer",user.get("SYSUSER_ISDELETE"));

                //登录日志计入
                sqlEngine log = new sqlEngine();
                log.getAddData("LOGS",user.get("SYSUSER_NAME")+"登录系统");
                log.getAddData("TYPE",0);//登录系统
                log.getAddData("UID",user.get("SYSUSER_ID"));
                baseSchema.insertData("LOGINFO",log);
            }
        } else {
            loginType = -1;
        }
        result.put("result", loginType);
        result.put("resultData", loginType == 0 ? "登录失败:您的账户已被禁用,请联系管理员" : loginType == -1 ? "登录失败:请检查您的账户名及密码是否有误" : "登录成功");
        return JSON.toJSONString(result);
    }

    private void sessionToken(oAuthToken oAuthToken, String nickName, HttpServletRequest request, BasePage user) throws Exception {
        String realIp = ipTool.GetRealIP(request);
        //更新用户的登陆信息
        sqlEngine updEngine = new sqlEngine();
        updEngine.getUpdateTables("SYSUSER")
                .getUpdateCols("SYSUSER_NAME", nickName)
                .getUpdateCols("SYSUSER_LASTIP", realIp)
                .getUpdateCols("SYSUSER_DATETIME",
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .getUpdCurrentVersion("SYSUSER", Integer.parseInt(user.get("SYSUSER_VERSION") + "") + 1)
                .getUpdateById(user.getString("SYSUSER_ID"));
        baseSchema.updateData("SYSUSER", updEngine);
        // 保存登录用户信息,页面使用
        SessionUtil.setUser(request, user);
        //鉴权级Token,作为接入后台接口的唯一凭证
        String token = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();

        oAuthToken.SetCookie("TOKEN", token);
        oAuthToken.SetCookie("UUID", user.getString("SYSUSER_ID"));

        request.getSession().setAttribute(token, user);
        //有效期为4个小时的系统Token
        //以当前登陆用户为主键
        jedisUtil.set("tk:"+user.getString("SYSUSER_ID"), md5Tool.md5Password(token + "|" + realIp), 144000L);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SessionUtil.setUser(request, null);
        oAuthToken oAuthToken = new oAuthToken(request,null);
        //清空用户数据缓存
        jedisUtil.delete("tk:"+oAuthToken.GetCookie("UUID"));
        request.getSession().setAttribute(oAuthToken.GetCookie("TOKEN"), null);
        //重置并清空Cookie
        oAuthToken.SetCookie("TOKEN",null);
        oAuthToken.SetCookie("UUID", null);
        oAuthToken.SetCookie("NAME", null);
        oAuthToken.SetCookie("RID", null);
        oAuthToken.SetCookie("AVATAR", null);
        try {
            response.sendRedirect(logoutUrl);
            return;
        } catch (IOException e) {
            logger.error("---LoginOAuthController ERROR:(logout注销跳转失败)-->"+e.getMessage(),e);
        }
    }
}
