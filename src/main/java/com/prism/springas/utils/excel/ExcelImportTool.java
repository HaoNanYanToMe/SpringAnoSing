package com.prism.springas.utils.excel;

import com.prism.springas.utils.BasePage;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 导出Excel接口统一调用
 */
public interface ExcelImportTool {

    /**
     * Import Excel Tool
     * Excel灵活导出工具类
     * @param pageData  需要导出的实体集合
     * @param cellName  字段值[Excel表头-支持中文]
     * @param tableName Excel文件名称
     * @return 导出数据流[input Stream]
     */
    ModelAndView importExcel(List<BasePage> pageData,
                             String cellName,
                             String cellParseName,
                             String tableName);

}
