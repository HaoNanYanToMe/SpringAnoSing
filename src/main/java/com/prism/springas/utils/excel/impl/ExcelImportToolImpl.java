package com.prism.springas.utils.excel.impl;

import com.prism.springas.utils.BasePage;
import com.prism.springas.utils.excel.ExcelImportTool;
import com.prism.springas.utils.excel.ExcelView;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Excel导出控件
 */
@Service("excelImportTool")
public class ExcelImportToolImpl implements ExcelImportTool {

    @Override
    public ModelAndView importExcel(List<BasePage> pageData, String cellName, String cellParseName,String tableName)
    {
        List<BasePage> PageDataList = new ArrayList<BasePage>();
        pageData.forEach((PageData) -> PageDataList.add(PageData));
        ModelMap model = new ModelMap();
        ExcelView v = new ExcelView();
        model.put("dataSet", PageDataList);
        model.put("cellName",cellName);
        model.put("cellParseName",cellParseName);
        model.put("tableName",tableName);
        return  new ModelAndView(v, model);
    }
}
