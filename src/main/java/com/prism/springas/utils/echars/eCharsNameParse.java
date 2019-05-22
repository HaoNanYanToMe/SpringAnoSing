package com.prism.springas.utils.echars;

/**
 * 对eChar数据字段进行预处理
 */
public class eCharsNameParse {

    public String parseName(String name){
        if (name.equals("AGENT_ENDED")){name = "顾问";}
        if (name.equals("CUSTOMER_ENDED")){name = "客户";}
        if (name.equals("Inbound")){name = "被叫";}
        if (name.equals("Outbound")){name = "主叫";}

        if (name.equals("ATIME")){name = "1分以内";}
        if (name.equals("BTIME")){name = "1~3分内";}
        if (name.equals("CTIME")){name = "3~5分内";}
        if (name.equals("DTIME")){name = "5~10分内";}
        if (name.equals("ETIME")){name = "15~20分内";}
        if (name.equals("FTIME")){name = "30分以上";}
        if (name.equals("GTIME")){name = "10~15分内";}
        if (name.equals("HTIME")){name = "20~30分内";}
        if (name.equals("ZTIME")){name = "未接通";}
        return name;
    }
}
