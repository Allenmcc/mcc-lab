package math;


/**
 * Created by chunchen.meng on 2019/7/14.
 * int的取值范围为（-2147483648~2147483647），占用4个字节（-2的31次方到2的31次方-1）
 */
public class MathUtils {
    public static void main(String[] args) {

        String ip = " 172 .168.5.1";
        String ip2 = "1 72.168.5.1";
        String ip3 = "172.168.5.1";

        System.out.println(ipTo32Hex(ip));
//        System.out.println(ipTo32Hex(ip2));
//        System.out.println(ipTo32Hex(ip3));

    }

    public static long ipTo32Hex(String str) {
        if (str == null || str.length() == 0) return -1;
        long ipUnit = 0, ret = 0;
        boolean bFindDot = true;
        int dotCnt = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (bFindDot) {
                if (c == ' ') {
                    //ipUnit== 0 直接返回
                    if (ipUnit != 0) {
                        if (ipUnit > 255 || ipUnit < 0) {
                            return -1;
                        }
                        ret = (ret << 8) + ipUnit;
                        ipUnit = 0;
                        bFindDot = false;
                    }
                } else if (c == '.') {
                    dotCnt++;
                    if (ipUnit > 255 || ipUnit < 0) {
                        return -1;
                    }
                    ret = (ret << 8) + ipUnit;
                    ipUnit = 0;
                    continue;
                } else {
                    ipUnit = ipUnit * 10 + str.charAt(i) - '0';
                }
            } else if (c == ' '){
                continue;
            }  else if (c == '.') {
                dotCnt++;
                bFindDot = true;
            } else {
                return -1;
            }
        }
        if (dotCnt != 3) return -1;
        if (bFindDot) {
            if (ipUnit > 255 || ipUnit < 0) {
                return -1;
            }
            ret = (ret << 8) + ipUnit;
        }
        return ret;
    }


    public static long ip2Long(String ip) {
        if (null == ip) {
            System.out.println("ip is null");
            return 0;
        }
        String[] ipStrs = ip.split("\\.");

        //Integer.MAX_VALUE is 2147483647
        long result = 0;
        for (int i = 0; i < 4; i++) {
            ipStrs[i] = ipStrs[i].trim();
            if (ipStrs[i].indexOf(" ") != -1) {
                System.out.println("Space error");
                return -1;
            }

            Long ipInteger = Long.parseLong(ipStrs[i]);
            if (ipInteger > 255) {
                System.out.println("more than 255");
                return -1;
            }
            result += (ipInteger << (24 - i * 8));
        }
        return result;
    }



}
