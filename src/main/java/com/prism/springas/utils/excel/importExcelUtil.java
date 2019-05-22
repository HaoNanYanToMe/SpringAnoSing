package com.prism.springas.utils.excel;


import com.prism.springas.utils.BasePage;

import java.util.Map;

public interface importExcelUtil {

    /**
     * 上传并解析Excel内数据
     * @param fileData   excel数据流
     * @param bp        对应的附加信息（用户）
     * @return
     * @throws Exception
     */
    public Map<String,String> importExcel(byte[] fileData, BasePage bp)  throws Exception;
}
