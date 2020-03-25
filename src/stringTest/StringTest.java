package stringTest;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by danny on 2017/1/18.
 */
public class StringTest {
    public static final   String SMS_TEMPLATE = "%s,%s钟内异常:%s,类型%s";

    public static void main(String[] args) {

//        String test = "121212";
//        System.out.println(test.substring(0,20));

//        String  ser = "E00001331_LEAVED";
        String  ser = "E00001331S";
        System.out.println(StringUtils.substringBefore(ser,"_"));

        String s = "";

      String[]  sp =  s.split(",");
//      sp[]

       String ss33 =  String.format(SMS_TEMPLATE,"aa",2,"npe","sd");

        String testaa = ",haha";
        String[] tolist = testaa.split(",");
        String length = "1哈";

        if(length.length()>=3){
            System.out.println(length.substring(0,3));
        }

        System.out.println(length.length()>3? length.substring(0,3):length);

        double aa =0;
        double bc =0;
        if(aa == 1)
        {
            System.out.println(11);
        }else if( bc == 2){
            System.out.println(2);
        }


        if((aa-0.0)<1e-6)
        {
            System.out.println(11);
        }

        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);

        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

        if(1.0-0.99999999f<1e-8){
            System.out.println("yes");
        }
        System.out.println(0.99999999f==1f);


        String ip ="1.2.3.4,2.3.4.1";
        String ip2 ="";

        //string -> array
        String []ips =  ip.split(",");
        String []ips2 =  ip2.split(",");
        System.out.println(ips[0]);
        System.out.println(ips2[0]);

        //array->list
        System.out.println("array->list:"+ Arrays.asList(ips));

//        String test = ips[0];
//        System.out.println(test);
//        test = "hh";
//        System.out.println(ips[0]);

        String []ips3 =  ips;

        System.out.println(ips3[0]);

        ips3[0] = "hh";
        System.out.println(ips[0]);



        String number = "1234A";
        System.out.println(number.toLowerCase());



        String ss = "/brandsite/brand/501/223760";
        int index = ss.lastIndexOf('/');
        String idStr = ss.substring(index+1);
        System.out.println(Integer.valueOf(idStr));

        String s2 = "2018-03-01";
        System.out.println(s2.replaceAll("-",""));


        String http= "http://";
        System.out.print(http.replace("http:","https:"));


        String b= "";
        System.out.println(StringUtils.isNotBlank(b));

        String aaa ="hh";
        String bbb ="hh";
        System.out.println(aaa.equals(bbb));
        System.out.println(aaa == bbb );

        String str11 = "高小天";
        String str22 = "高小天";
        System.out.println(str11==str22);//true 享元模式

        String str3 = new String("高大天");
        String str4 = new String("高大天");
        System.out.println(str3==str4);//false

        String ss1 = "imooc";
        String ss2 = "imooc";

        //定义字符串s3，保存“I love”和s1拼接后的内容

        String ss3="I love"+ss1;
        // 比较字符串ss1和ss2
        // imooc为常量字符串，多次出现时会被编译器优化，只创建一个对象 享元模式
        System.out.println("s1和s2内存地址相同吗？" + (ss1 == ss2));

        //比较字符串ss1和ss3
        System.out.println("s1和s3内存地址相同吗？" + (ss1 == ss3 ));

        String ss4 = "I love " + ss1;
        //比较字符串s4和s3
        // ss1是变量，ss4在运行时才知道具体值，所以ss3和ss4是不同的对象
        System.out.println("s3和s4内存地址相同吗？" + (ss4 == ss3));



        String t1 = "";
        String t2 = "";

        System.out.println(t1 == t2);

        System.out.println(isValidPic(""));





    }

    public static boolean isValidPic(String url) {

        if (url == null || url == "") {
            return true;
        }

        return url.contains("");
    }

    @Test
    public void splitTest(){
        String s = "[CAT异常告警] [项目: business-gateway-external] [CAT异常告警] [项目: business-gateway-external] : [ 异常名称: java.lang.NullPointerException 异常数量：6.0 ][时间: 2020-02-24 16:38]     [告警间隔时间]2分钟";

       String s1 =  StringUtils.substringBeforeLast(s, "[CAT");
       String s2 =  StringUtils.substringAfterLast(s, "[CAT异常告警] ");
       String s3 =  s2.replaceAll(" ","").replaceAll("\\[","").replaceAll("\\]","").replaceAll(":","").replace("：","").replaceAll("CAT","").replaceAll("项目","").replaceAll("名称","").replaceAll("异常","").replaceAll("时间","").replaceAll("告警","");

      String s33 = s3.substring(0,65);

      String s5  = StringUtils.substringAfterLast(s3,"CAT异常告警");

      String name =  StringUtils.substringBefore(StringUtils.substringAfter(s ,"[项目: "),"]");
      String cnt =  StringUtils.substringBefore(StringUtils.substringAfter(s ,"异常数量："),".0");
      String type =  StringUtils.substringBefore(StringUtils.substringAfter(s ,"[ 异常名称: ")," 异常数量");
      String gapTime = StringUtils.substringAfter(s ,"[告警间隔时间]");

//     String s4 =  strHandler(s, p->p.substring(2));

        System.out.println(s.split(" "));

       System.out.println(s5);


    }

    public static String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }


}