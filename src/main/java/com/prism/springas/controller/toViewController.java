package com.prism.springas.controller;

import com.alibaba.fastjson.JSON;
import com.prism.springas.controller.config.BaseBasicExtends;
import com.prism.springas.utils.sqlEngine.sqlEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

//前端使用展示接口
@RestController
public class toViewController extends BaseBasicExtends {
    //序列化
    private static final long serialVersionUID = 1L;
    //开启log4j日志
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/selectViewBase",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public String selectBase(
            @RequestParam(value = "selTable") String selTable,
            @RequestParam(value = "tables", required = false, defaultValue = "") String tables,
            @RequestParam(value = "columns", required = false, defaultValue = "") String columns,
            @RequestParam(value = "sortColumns", required = false, defaultValue = "") String sortColumns,
            @RequestParam(value = "sortTypes", required = false, defaultValue = "") String sortTypes,
            @RequestParam(value = "pageNo") Integer pageNo,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "data", required = false, defaultValue = "{}") String data) throws Exception {
        sqlEngine sqlEngine = super.jsonToSqlEngine(0, data);
        if (sqlEngine == null) {
            return JSON.toJSONString("#JSON入参数据非法,请检查格式无误后重试!");
        } else {
            if(selTable.contains("DRUGINFO")||selTable.contains("DTINFO")) {
                //1.必传参数[需查询数据表表名]
                sqlEngine.getSelTable(selTable)
                        //2.非必传参数[查询指定表全表字段,查询指定表特定字段](如都不传,则视为查询全部)
                        .getSelCols(tables == null ? "" : tables, columns == null ? "" : columns)
                        //3.是否需要执行分页(默认为第1页,单页载入20条数据)
                        .getPage(pageNo == null ? 1 : pageNo, pageSize == null ? 20 : pageSize);
                //4.是否需要执行排序
                if (sortColumns != null && !sortColumns.equals("")) {
                    sqlEngine.getSort(sortColumns, sortTypes);
                }
                //获取主表NAME
                String[] tableArray = selTable.split(",");
                //通过Prism棱镜获取数据返回结果

                Object reObj = super.invokeSchemaMethod(0, tableArray[0],
                        "selectPage", sqlEngine);
                return reObj == null ? "" : reObj.toString();
            }else{
                return JSON.toJSONString("#无数据操作权限!");
            }
        }
    }
}
