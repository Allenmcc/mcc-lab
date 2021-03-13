package stringTest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by danny on 2017/1/18.
 */
public class StringTest {
    public static final   String SMS_TEMPLATE = "%s,%s钟内异常:%s,类型%s";


    public static String replaceBlank(String str) {

        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


    public static void main(String[] args) {


        String ll = "6个\\双";  //length 4   \\长度1,第一个转义符   其他系统\\里面当做2,当做2个字符处理
        String ll2 = "从\\PO签";  //length 4   \\长度1,第一个转义符   其他系统\\里面当做2,当做2个字符处理
        String lenth500 = "产品线:21;产品类型:hardware;品牌:联想（北京）信息技术有限公司;名称:服务器;产品型号:;产品描述:1、机架式服务器，2个英特尔® 至强® 可扩展处理器Bronze(铜) 3204 1.9GHz 6C(核) 85W 8.25MB三级缓存 9.6 GT/s UPI 85W，支持最大内存速度2133 MHz，最大支持2颗CPU，4条16GB TruDDR4 2666 MHz (2Rx8 1.2V) RDIMM内存(7X77A01303)，具备12个内存插槽，支持最大可配置(单CPU 6个\\双CPU 12个内存)，配置3块600GB 2.5英寸SAS硬盘, 标配\\最大支持8个2.5\"硬盘背板插槽，标配RAID 730-8i 1GB Cache PCIe 12Gbps 阵列卡,支持RAID0/1/10/5/50(7Y37A01083)，标配2个集成1GbE RJ-45网口(非LOM卡，标配LOM卡槽为空，可选填)和1个管理网络端口，2个USB3.0接口和1个VGA接口，标配2个PCIE插槽（Raid卡占用1个），通过添加选件Riser卡2可最大支持3个PCIe 3.0插槽（2个空";
        String lenth500V2 = "产品线:86;产品类型:hardware;品牌:华为;名称:核心交换机;产品型号:;产品描述:02352UTN\\tCE16804A-B01\\tCE16804交流组合配置1(含交流/高压直流总装机箱,2*主控板D,4*交换网板F,4*3000W 交流&高压直流电源模块,满配风机盒)\\t1\\n88035UBL\\tN1-CE168LIC-CFMM\\tN1-CloudEngine 16800交换机CloudFabric 产品线:86;产品类型:hardware;品牌:华为;名称:核心交换机;产品型号:;产品描述:02352UTN\\tCE16804A-B01\\tCE16804交流组合配置1(含交流/高压直流总装机箱,2*主控板D,4*交换网板F,4*3000W 交流&高压直流电源模块,满配风机盒)\\t1\\n88035UBL\\tN1-CE168LIC-CFMM\\tN1-CloudEngine 16800交换机CloudFabric ";
        String lenth500V3 = "产;TN\tCE168isPresent04A-B01\tCE16804交流组\r合电源模块,满配风机盒)\t1\n88035UBL";

       String re = lenth500V2.replace("\\t"," ").replace("\\n"," ");
       String re3 = lenth500V2.replaceAll("\t|\n"," ");
       String re2 = replaceBlank(lenth500V2);

        System.out.println(lenth500.length());

        org.springframework.util.StringUtils.trimAllWhitespace(re);

        String fiLength = lenth500.length() >=500?lenth500.substring(0,500):lenth500;
        System.out.println(fiLength);
        System.out.println(fiLength.length());

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

       String ss11 = "1,2,3,";
       String ss22 = "1,2,3";

        System.out.println(ss11.substring(ss11.length()-1));
        String s11 =  StringUtils.substringBeforeLast("1,2,3,", ",");
        String s12 =  StringUtils.substringBeforeLast("1,2,3", ",");

        System.out.println(s11);
        System.out.println(s12);


    }

    public static String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }


    @Test
    public void testString(){
//        String[] arr = {"1","2"};
        String[] arr =null;
        // 数组转字符串 org.apache.commons.lang3.ArrayUtils
        String str2 = ArrayUtils.toString(arr, ","); // 数组转字符串(逗号分隔,首尾加大括号)
        System.out.println(str2); // {0,1,2,3,4,5}
    }


    @Test
    public void testString2() {
        String[] arr = {"1", "2"};
//        String[] arr = null;
//数组转字符串 org.apache.commons.lang3.StringUtils
        String str3 = StringUtils.join(arr); // 数组转字符串,其实使用的也是遍历
        System.out.println(str3); // 012345
        String str4 = StringUtils.join(arr, ","); // 数组转字符串(逗号分隔)(推荐)
        System.out.println(str4); // 0,1,2,3,4,5


    }

    @Test
    public void testStringContains(){
        String arr ="11,22,33";
        System.out.println(arr.contains("2")); // {0,1,2,3,4,5}
    }





}