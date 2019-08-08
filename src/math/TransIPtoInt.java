package math;

import java.util.Scanner;

/**
 * Created by chunchen.meng on 2019/7/12.
 */
public class TransIPtoInt {
    //IP转化为int
    public long iPToInt(String ip) throws Exception {

        //正则表达式对IP进行判断
        ip = ip.trim();
        String regular = "^[0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}$";
        if(!ip.matches(regular)){
            throw new Exception("IP地址有误！");
        }

        //注意1：如果用“.”作为分隔的话,必须是如下写法,String.split("\\."),这样才能正确的分隔开,不能用String.split(".");
        //注意2：IP地址检查。
        String[] iparray = ip.split("\\.");
        int hex = 8;
        long ipnum = 0;
        for (int i = 0; i < iparray.length; i++) {
            if(Integer.parseInt(iparray[i]) > 255){
                throw new Exception("IP地址超过255");
            }
            long f = Integer.parseInt(iparray[i]);
            //注意：先乘除,确定移位数，再移位
            f = f << (iparray.length - i - 1) * hex;
            ipnum += f;
        }
        return ipnum;
    }


    //int数转IP
    public String intToIP(long ipnum) {

        String intnum = "";
        int hex = 8;
        int count = 1;
        for (int j = 3; j > 0; j--) {
            intnum += ipnum / (count << hex * j);
            ipnum %= (count << hex * j);
            intnum += ".";
        }
        return intnum += ipnum;
    }

    //主方法测试
    public static void main(String[] args) throws Exception {

        String ip = "0.256.1.53";
        Scanner scan = new Scanner(System.in);
        ip = scan.nextLine();
        TransIPtoInt tp = new TransIPtoInt();

        long ipnum = tp.iPToInt(ip);
        System.out.println(ipnum);

        System.out.println(tp.intToIP(ipnum));
    }
}
