public class SumTest {


    public static String getSum(String a, String b) {

        if(a.length()<b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }

        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int[] result = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int length = aa.length > bb.length ? aa.length : bb.length;

        boolean flag = false;
        for (int i = length - 1, j = b.length() - 1; i >= 0; i--, j--) {
            int tmp = j >= 0 ? (Integer.valueOf(aa[i] - '0') + Integer.valueOf(bb[j] - '0')) : Integer.valueOf(aa[i] - '0');
            if (flag) {
                result[i] = 1 + tmp % 10;
            } else {
                result[i] = tmp % 10;
            }
            if (tmp >= 10) {
                flag = true;
            }else {
                flag = false;
            }
        }
        String resultStr = "";
        for (int tmp : result) {
            if (tmp == 0) continue;
            resultStr = resultStr + String.valueOf(tmp);
        }
        return resultStr;
    }

    public static void main(String[] args) {

//        String a = "123";
        String a = "123456789";
        String b = "31";

        String result = getSum(a, b);
        System.out.println(result);

    }
}
