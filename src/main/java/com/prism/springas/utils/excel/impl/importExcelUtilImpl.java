package com.prism.springas.utils.excel.impl;

import com.prism.springas.api.BaseApi;
import com.prism.springas.utils.BasePage;
import com.prism.springas.utils.excel.importExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class importExcelUtilImpl implements importExcelUtil,Serializable {

    private static final Logger log = LoggerFactory.getLogger(importExcelUtilImpl.class);

    @Autowired
    BaseApi baseApi;

    //HSSText  Excel内部信息字段处理
    private String getHSSTextString(Row row, int colNum) {
        Cell cell = row.getCell(colNum);
        if (null != cell) {
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC:
                    return cell.getNumericCellValue()+"";
                case HSSFCell.CELL_TYPE_STRING:
                    return cell.getStringCellValue().trim();
                case HSSFCell.CELL_TYPE_BLANK: // 空值
                    return "";
                case HSSFCell.CELL_TYPE_ERROR: // 故障
                    return "";
                case HSSFCell.CELL_TYPE_FORMULA:
                    try {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        return String.valueOf(cell.getStringCellValue());
                    } catch (IllegalStateException e) {
                        return String.valueOf(cell.getNumericCellValue());
                    }
                default:
                    return "";
            }
        } else {
            return "";
        }
    }


    @Override
    public Map<String, String> importExcel(byte[] fileData, BasePage bp) throws Exception {
        Map<String,String> result = new HashMap<>();
        result.put("result","数据录入成功");
        File tempFile;
        try {
            tempFile = File.createTempFile("excel", ".xlsx");
            FileOutputStream ots=new FileOutputStream(tempFile);
            ots.write(fileData);
            ots.flush();
            ots.close();
            Workbook workbook = WorkbookFactory.create(new FileInputStream(tempFile));
            Sheet sheet = workbook.getSheetAt(0);  //示意访问sheet
            int rowNum = sheet.getPhysicalNumberOfRows();// 返回物理行数

            int suc = 0;
            /* String type = ""; */
            for (int i = 2; i < rowNum ; i++) {
                Row row = sheet.getRow(i);// 获取第i行数据
                if (!"".equals(getHSSTextString(row, 0).toString())) {

                }
            }
        } catch (IOException e) {
            log.debug("",e);
        }
        return result;
    }

}
