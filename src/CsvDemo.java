import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danny on 15/10/28.
 */

class ChangeCharset {
    /** 8 位 UCS 转换格式 */
    public static final String UTF_8 = "UTF-8";
    /** 中文超大字符集 **/
    public static final String GBK = "GBK";

    /** 将字符编码转换成UTF-8 */
    public String toUTF_8(String str) throws UnsupportedEncodingException {
        return this.changeCharset(str, UTF_8);
    }

    /** 将字符编码转换成GBK */
    public String toGBK(String str) throws UnsupportedEncodingException {
        return this.changeCharset(str, GBK);
    }

    public String changeCharset(String str, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            // 用默认字符编码解码字符串。与系统相关，中文windows默认为GB2312
            byte[] bs = str.getBytes();
            return new String(bs, newCharset); // 用新的字符编码生成字符串
        }
        return null;
    }

    /**
     * 字符串编码转换的实现方法
     *
     * @param str
     *            待转换的字符串
     * @param oldCharset
     *            源字符集
     * @param newCharset
     *            目标字符集
     */
    public String changeCharset(String str, String oldCharset, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            // 用源字符编码解码字符串
            byte[] bs = str.getBytes(oldCharset);
            return new String(bs, newCharset);
        }
        return null;
    }
}
public class CsvDemo {
    public static void main(String[] args) {
        List<String> sqlData = new ArrayList<String>();
        final String GBK = "GBK";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\csvdemo.csv"));
            try {
                reader.readLine();
                String line = null;
                while ((line = reader.readLine())!=null){
                    String item[] = line.split(",");
                    String test = item[0];
                    System.out.println(test.equals("南宁"));
                    String city ="南宁";
                    String city2 = "保定";
                    String city3 = "昆明";

                    ChangeCharset tes11 = new ChangeCharset();
                    String str = "南宁";
                    System.out.println("str：" + str);

                    String gbk = tes11.toGBK(str);
                    System.out.println("转换成GBK码：" + gbk);
                    System.out.println();

                    System.out.println(city);
                    if (test.equals(city)) {
                        String itemlist = "insert into MRM_Keyword(Keyword, CityID, PriceLevel, TopThreeStock, FirstPageStock, `Status`, AddTime) VALUES " +
                                "('" + item[1] + "', 224, " + item[3] + ", 3, 15, 1, NOW());"; // 最重要的是keyword和priceLevel
                        sqlData.add(itemlist);
                    }else if (test.equals(city3)){
                        String itemlist = "insert into MRM_Keyword(Keyword, CityID, PriceLevel, TopThreeStock, FirstPageStock, `Status`, AddTime) VALUES " +
                                "('" + item[1] + "', 267, " + item[3] + ", 3, 15, 1, NOW());"; // 最重要的是keyword和priceLevel
                        sqlData.add(itemlist);
                    }else if (test.equals(city2)){
                        String itemlist = "insert into MRM_Keyword(Keyword, CityID, PriceLevel, TopThreeStock, FirstPageStock, `Status`, AddTime) VALUES " +
                                "('" + item[1] + "', 29, " + item[3] + ", 3, 15, 1, NOW());"; // 最重要的是keyword和priceLevel
                        sqlData.add(itemlist);
                    }
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String a: sqlData){
            System.out.println(a);
        }
    }
}
