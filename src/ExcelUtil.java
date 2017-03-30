import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by danny on 2017/1/19.
 */
public class ExcelUtil {
    /**
     * 创建excel文档，
     * @param list 数据
     * @param keys list中map的key数组集合
     * @param columnNames excel的列名
     * */
    public static Workbook createWorkBook(List<Map<String, Object>> list, List<String> keys, List<String> columnNames) {
        // 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        // 创建第一个sheet（页），并命名
        Sheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for (int i = 0; i < keys.size(); i++) {
            if (i == 0) {
                sheet.setColumnWidth((short) i, (short) (35.7 * 150 * 2));
            } else {
                sheet.setColumnWidth((short) i, (short) (35.7 * 150));
            }
        }

        // 创建第一行
        Row row = sheet.createRow((short) 0);

        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // 创建第一种字体样式（用于列名）
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.BLACK.getIndex());
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);

        // 创建第二种字体样式（用于值）
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());

//        Font f3=wb.createFont();
//        f3.setFontHeightInPoints((short) 10);
//        f3.setColor(IndexedColors.RED.getIndex());

        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        cs.setAlignment(CellStyle.ALIGN_CENTER);

        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        cs2.setAlignment(CellStyle.ALIGN_CENTER);
        //设置列名
        for(int i=0;i<columnNames.size();i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames.get(i));
            cell.setCellStyle(cs);
        }
        //设置每行每列的值
        for (short i = 1; i < list.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
            Row row1 = sheet.createRow((short) i);
            // 在row行上创建一个方格
            for(short j=0;j<keys.size();j++){
                Cell cell = row1.createCell(j);
                cell.setCellValue(list.get(i).get(keys.get(j)) == null?" ": list.get(i).get(keys.get(j)).toString());
                cell.setCellStyle(cs2);
            }
        }
        return wb;
    }
    public static  void createResponse(HttpServletResponse response, ByteArrayOutputStream os, String fileName)  throws IOException {
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        }
        finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
    }

    public static <T> List<Map<String, Object>> createExcelRecord( List<T> projects, List<String> propertyList,Class<T> clazz) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        //Object project;
        for (int j = 0; j < projects.size(); j++) {
            T project=projects.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            for(String property: propertyList ){
                StringBuffer pro = new StringBuffer();
                String proper = property;
                pro.append("get");
                property = property.substring(0,1).toUpperCase()+property.substring(1);
                property = pro.append(property).toString();
                try {
                    Method method=clazz.getMethod(property);
                    mapValue.put(proper, method.invoke(project));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            listmap.add(mapValue);
        }
        return listmap;


    }

    public static void main(String args[]){
        List<String> columnNames = new ArrayList<>();
        columnNames.add("aa");
        columnNames.add("bb");
        columnNames.add("cc");

        List<String> properties =new ArrayList<>();
        properties.add("a");
        properties.add("b");
        properties.add("c");

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        List<Map<String, Object>> projects = new ArrayList<>();

//        List<Map<String, Object>> list = ExcelUtil.createExcelRecord(projects, properties, ManagerReportDTO.class);

//        ExcelUtil.createWorkBook(list, properties, columnNames).write(os);

    }



}
