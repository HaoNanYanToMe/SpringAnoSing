package com.prism.springas.utils.excel;

import com.prism.springas.utils.BasePage;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class ExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<BasePage> mt = (List<BasePage>) model.get("dataSet");
		HSSFSheet sheet = workbook.createSheet(model.get("tableName").toString());
        //处理Excel表头字体样式(Cell)
        HSSFFont fontCell =workbook.createFont();
        fontCell.setFontHeightInPoints((short) 10); //字体高度
        fontCell.setColor(HSSFFont.COLOR_RED); //字体颜色
        fontCell.setFontName("微软雅黑"); //字体
        fontCell.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //宽度
        //处理Excel表头样式(Cell)
        HSSFCellStyle cellStyle =workbook.createCellStyle();
        cellStyle.setFont(fontCell);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平布局：居中
        cellStyle.setWrapText(true);
        //处理Excel内容字体样式(Row)
        HSSFFont fontRow =workbook.createFont();
        fontRow.setFontHeightInPoints((short) 10); //字体高度
        fontRow.setFontName("微软雅黑"); //字体
        //处理Excel表头样式(Row)
        HSSFCellStyle rowStyle =workbook.createCellStyle();
        rowStyle.setFont(fontRow);
        rowStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平布局：居中
        rowStyle.setWrapText(true);
        //处理Excel表头字体样式(无数据导出)
        HSSFFont fontNull =workbook.createFont();
        fontNull.setFontHeightInPoints((short) 16); //字体高度
        fontNull.setColor(HSSFFont.COLOR_RED); //字体颜色
        fontNull.setFontName("微软雅黑"); //字体
        fontNull.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //宽度
        //处理Excel表头样式(无数据导出)
        HSSFCellStyle cellNull =workbook.createCellStyle();
        cellNull.setFont(fontNull);
        cellNull.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平布局：居中
        cellNull.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直
        cellNull.setWrapText(true);
        ExcelViewConfig cfg = new ExcelViewConfig();
        //判断是否有内容
        if(mt.size() != 0) {
            //获取字段列表（需和mapper中保持一致，若用到了as字段，则填写as字段的值即可,支持中文）
            String [] cellName = model.get("cellName").toString().split(",");
            String [] cellParseName = model.get("cellParseName").toString().split(",");
            HSSFCell cell;
            sheet.setDefaultColumnWidth(cellName.length);

            for (int i = 0; i <= cellParseName.length; i++) {
                cell = getCell(sheet, 0, i);
                if (i == cellName.length) {
                    setText(cell, "");
                } else {
                    setText(cell, cellParseName[i]);
                }
                cell.setCellStyle(cellStyle);
            }

            for (int i = 0; i < mt.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                BasePage pd = mt.get(i);
                //循环CellName获取值
                for (int j = 0; j < cellName.length; j++) {
                    cell = row.createCell(j);
                    if (j < cellName.length) {
                        Object o = pd.get(cellName[j].trim());
                        cell.setCellValue(o==null?"":cfg.parseCellValue(cellName[j],o.toString()));
                    } else {
                        row.createCell(j).setCellValue("");
                    }
                    cell.setCellStyle(rowStyle);
                }
            }

            for (int i = 0; i <= cellName.length; i++) {
                // ==**==本方法在linux不适用
                sheet.autoSizeColumn((short) i,true); //调整列宽度
//                sheet.setColumnWidth((short) i,cellName.toString().getBytes().length*2*256);
            }
        }else{
            HSSFCell cell = getCell(sheet,0,0);
            setText(cell, "Sorry,It's no true Data!(很抱歉，没有符合的数据或您权限不足！)");
            cell.setCellStyle(cellNull);
            sheet.setColumnWidth(0,2000);
            sheet.addMergedRegion(new CellRangeAddress(0,10,0,20));
        }

        // 处理中文文件名Name
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "filename="
                + new String(cfg.parseTableName(model.get("tableName").toString()).getBytes("gb2312"), "iso8859-1"));//设置文件头编码方式和文件名

        OutputStream outputStream = response.getOutputStream();

        workbook.write(outputStream);

        outputStream.flush();

        outputStream.close();
	}

}
