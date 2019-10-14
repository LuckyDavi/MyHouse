package com.learn.util;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.List;

import java.util.regex.Pattern;

/**
 * @Author XieWei
 * @Description excel工具类
 * @Created Date 2019/10/12 17:28
 *
 * 该工具类的依赖jar包
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi</artifactId>
        <version>4.1.0</version>
    </dependency>
 **/
public class ExcelUtil {

    /**
     *  导出excel，支持单个sheet
     * @param response
     * @param fileName 导出后存放的文件名
     * @param sheetName 工作簿的名称，默认为sheet1
     * @param titles 表头内容
     * @param colWidths 表头列宽
     * @param list 要导出的数据，可根据需求修改格式
     */
    public static void exportExcel(
            HttpServletResponse response,
            String fileName, String sheetName,
            String[] titles, Integer[] colWidths, List<List<String>> list){
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            if(StringUtils.isBlank(sheetName)){
                sheetName = "sheet1";
            }
            //创建工作簿sheet
            HSSFSheet sheet = workbook.createSheet(sheetName);
            //Biff8EncryptionKey.setCurrentUserPassword("ZHONGKEYUAN");
            //创建表头
            createTitle(workbook, sheet, titles, colWidths, 0);
            //创建数据部分
            createCell(workbook, sheet, list, 0);

            response.setContentType("application/octet-stream");
            response.setHeader(
                    "Content-disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName+".xls","utf-8"));
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description:创建表头
     * @param workbook
     * @param sheet 工作簿
     * @param titles 表头内容
     * @param colWidths 指定表头各元素的列宽，要求与titles数组的长度保持一致
     * @param rows 一般是第0行
     * @return
     */
    public static HSSFCellStyle createTitle(HSSFWorkbook workbook, HSSFSheet sheet, String[] titles,Integer[] colWidths, Integer rows){
        HSSFCellStyle titleStyle = titleCellStyle(workbook);
        //创建第rows行，一般表头设置成第0行
        HSSFRow row = sheet.createRow(rows);
        //按传入的表头内容的顺序填充表头内容
        for(int i=0;i<titles.length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(titleStyle);
            //设置列宽
            sheet.setColumnWidth(i, colWidths[i]*256);
        }
        return titleStyle;
    }

    /**
     * @description:创建表格的数据部分，可根据需要的导出的数据具体情况修改
     * @param workbook
     * @param sheet
     * @param listData
     * @param rows
     */
    public static void createCell(HSSFWorkbook workbook, HSSFSheet sheet, List<List<String>> listData, Integer rows){
        HSSFCellStyle style = cellStyle(workbook);
        for (int i=0;i<listData.size();i++){
            HSSFRow row = sheet.createRow(rows+i+1);
            List<String> data = listData.get(i);
            for(int k=0;k<data.size();k++){
                String val = data.get(k);
                if(null == val){
                    val = "";
                }
                HSSFCell cell = row.createCell(k);
                // 判断是否为数字类型
                if (isDigit(val)) {
                    //可能会是小数，转为Long会报错 因此在这里转为double
                    cell.setCellValue(Double.parseDouble(val));
                } else {
                    cell.setCellValue(val);
                }
                cell.setCellStyle(style);
            }
        }
    }

    /**
     * @description:设置表头的样式
     * @param workbook
     * @return
     */
    private static HSSFCellStyle titleCellStyle(HSSFWorkbook workbook) {
        //*******************设置字体样式*******************
        Font titleFont = workbook.createFont();
        //字体类型
        titleFont.setFontName("微软雅黑");
        //字体加粗，默认不加粗
        titleFont.setBold(true);
        //字体大小
        titleFont.setFontHeightInPoints((short) 12);
        //字体高度
        titleFont.setFontHeight((short) 260);
        //字体颜色
        titleFont.setColor(IndexedColors.BLACK.getIndex());

        //*******************设置单元格样式*******************
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        //设置单元格的水平对齐方式
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置单元格的垂直对齐方式
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置字体
        titleStyle.setFont(titleFont);
        //设置单元格的边框
        setBorder(titleStyle, BorderStyle.THIN);
        return titleStyle;
    }

    /**
     * @description:设置表格数据部分的样式
     * @param workbook
     * @return
     */
    private static HSSFCellStyle cellStyle(HSSFWorkbook workbook) {
        //*******************设置字体样式*******************
        Font font = workbook.createFont();
        //字体类型
        font.setFontName("宋体");
        //字体大小
        font.setFontHeightInPoints((short) 12);
        //字体高度
        font.setFontHeight((short) 220);

        //*******************设置单元格样式*******************
        HSSFCellStyle style = workbook.createCellStyle();
        //设置单元格的水平对齐方式
        style.setAlignment(HorizontalAlignment.CENTER);
        //设置单元格的垂直对齐方式
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置字体
        style.setFont(font);
        //设置单元格的边框
        setBorder(style, BorderStyle.THIN);
        return style;
    }

    /**
     * @description:设置单元格的上下左右边框
     * @param style
     * @param border
     */
    private static void setBorder(HSSFCellStyle style, BorderStyle border) {
        //设置上边框
        style.setBorderTop(border);
        //设置下边框
        style.setBorderBottom(border);
        //设置左边框
        style.setBorderLeft(border);
        //设置右边框
        style.setBorderRight(border);
    }

    /**
     * @description: 判断是否为数字类型（含+-号及小数点也能校验）
     * @param: str
     * @return: boolean
     */
    private static boolean isDigit(String str) {
        Pattern pattern = Pattern.compile("^[-|+]?[0]|([1-9]\\d*(\\.\\d+)?)");
        return pattern.matcher(str).matches();
    }
}
