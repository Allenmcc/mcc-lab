package stringTest;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by danny on 2017/1/18.
 */
public class StringTest {
    public static void main(String[] args) {

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



}