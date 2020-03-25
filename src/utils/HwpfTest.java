package utils;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HwpfTest {
    public static void main(String[] args) {
        String templatePath = "/Users/chunchenmeng/Desktop/template.doc";
        InputStream is = null;
        try {
            is = new FileInputStream(templatePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HWPFDocument doc = null;
        try {
            doc = new HWPFDocument(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Range range = doc.getRange();
        //把range范围内的${reportDate}替换为当前的日期
        range.replaceText("${reportDate}", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        range.replaceText("${appleAmt}", "100.00");
        range.replaceText("${bananaAmt}", "200.00");
        range.replaceText("${totalAmt}", "300.00");
        OutputStream os = null;
        try {
            os = new FileOutputStream("/Users/chunchenmeng/Desktop/write.doc");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //把doc输出到输出流中
        try {
            doc.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeStream(os);
        closeStream(is);
    }


    /**
     * 关闭输入流
     * @param is
     */
    private static void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     * @param os
     */
    private static void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
