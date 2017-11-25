/**
 * Created by danny on 2017/1/18.
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = "IPH-集团-餐饮平台-到店餐饮销售部-推广业务部-推广销售-华北区域-津鲁区域";
        // 从头开始查找是否存在指定的字符

        String reg = "推销售";
//        int startIndex = str1.indexOf(reg);
//        System.out.println(startIndex);
        // 从第四个字符位置开始往后继续查找
//        System.out.println(str1.substring(startIndex));
        //若指定字符串中没有该字符则系统返回-1
//        System.out.println(str1.indexOf("x"));



        String str[] = new String[9];
        System.out.println(str.length);
        String[]  str2 = str1.split("-");
        System.out.println(str2.length);

        for(int i =0;i<str2.length;i++){
            str[i] = str2[i];

        }
        for (int j = 0; j < str.length; j++) {
            System.out.println(str[j]);
        }

        System.out.println("end");

//        str = str2;
//        System.out.println(str.length);



//        for (String ss:str) {
//            System.out.println(ss);
//
//        }

        double aa =0;
        if(aa == 0)
        {
            System.out.println(11);
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
        String []ips =  ip.split(",");
        String []ips2 =  ip2.split(",");
        System.out.println(ips[0]);
        System.out.println(ips2[0]);

//        String test = ips[0];
//        System.out.println(test);
//        test = "hh";
//        System.out.println(ips[0]);

        String []ips3 =  ips;

        System.out.println(ips3[0]);

        ips3[0] = "hh";
        System.out.println(ips[0]);





    }


}