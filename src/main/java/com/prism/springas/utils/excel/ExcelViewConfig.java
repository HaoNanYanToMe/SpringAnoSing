package com.prism.springas.utils.excel;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 配置类 作为导出类的配置信息存放
 */
@Component
public class ExcelViewConfig {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static ExcelViewConfig excelViewConfig;

    @PostConstruct
    public void init(){
        excelViewConfig = this;
    }

    /**
     * 将列名转换成列表表头
     * @param enCellName 英文的列名
     * @return
     */
    String parseCellName(String enCellName){
        String cnCellName = enCellName;
        if(enCellName.equals("ROLE0_ROLENAME")){cnCellName = "所属部门";}
        return cnCellName;
    }

    /**
     * 字段特殊值转化
     * @param enCellName    列名
     * @param enCellValue   值
     * @return  处理结果
     */
    String parseCellValue(String enCellName,String enCellValue) throws Exception {
        String cnCellValue = enCellValue;
        if(enCellName.contains("CALLTYPE")){
            cnCellValue =  enCellValue.equals("Outbound") ? "呼出" : "接入";
        }
        if(enCellName.contains("CALLENDRESPONSECODE")){
            cnCellValue =  enCellValue.equals("CUSTOMER_ENDED") ? "客户挂断" : "顾问挂断";
        }
        if(enCellName.equals("SAMPLE_TYPE")){
            cnCellValue = enCellValue.equals("0") ? "优质" : "劣质";
        }
        return cnCellValue;
    }

    /**
     * 将表名转换成Excel导出文件名
     * @param TableName 表名
     * @return
     */
    String parseTableName(String TableName){
        return  TableName+"("+sdf.format(new Date())+").xls";
    }

    //由出生日期获得年龄
    String getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age + "," + yearBirth+"年"+monthBirth+"月"+dayOfMonthBirth +"日";
    }
}
