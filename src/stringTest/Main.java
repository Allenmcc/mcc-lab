package stringTest;

/**
 * Created by chunchen.meng on 2019/3/2.
 */
public class Main {
//    private static int time = 50000;
//
//    public static void main(String[] args) {
////        String str1 = "hello world";
////        String str2 = new String("hello world");
////        String str3 = "hello world";
////        String str4 = new String("hello world");
////
////        System.out.println(str1==str2);
////        System.out.println(str1==str3);
////        System.out.println(str2==str4);
//
//            testString();
//            testStringBuffer();
//            testStringBuilder();
//            test1String();
//            test2String();
//        }
//
//        public static void testString(){
//            String s = "";
//            long begin = System.currentTimeMillis();
//            for (int i = 0; i < time; i++) {
//                s += "java";
//            }
//            long over = System.currentTimeMillis();
//            System.out.println("操作" + s.getClass().getName() + "类型使用的时间为：" + (over - begin) + "毫秒");
//        }
//
//        public static void testStringBuffer () {
//            StringBuffer sb = new StringBuffer();
//            long begin = System.currentTimeMillis();
//            for(int i=0; i<time; i++){
//                sb.append("java");
//            }
//            long over = System.currentTimeMillis();
//            System.out.println("操作"+sb.getClass().getName()+"类型使用的时间为："+(over-begin)+"毫秒");
//        }
//
//        public static void testStringBuilder () {
//            StringBuilder sb = new StringBuilder();
//            long begin = System.currentTimeMillis();
//            for(int i=0; i<time; i++){
//                sb.append("java");
//            }
//            long over = System.currentTimeMillis();
//            System.out.println("操作"+sb.getClass().getName()+"类型使用的时间为："+(over-begin)+"毫秒");
//        }
//
//        public static void test1String () {
//            long begin = System.currentTimeMillis();
//            for(int i=0; i<time; i++){
//                String s = "I"+"love"+"java";
//            }
//            long over = System.currentTimeMillis();
//            System.out.println("字符串直接相加操作："+(over-begin)+"毫秒");
//        }
//
//        public static void test2String () {
//            String s1 ="I";
//            String s2 = "love";
//            String s3 = "java";
//            long begin = System.currentTimeMillis();
//            for(int i=0; i<time; i++){
//                String s = s1+s2+s3;
//            }
//            long over = System.currentTimeMillis();
//            System.out.println("字符串间接相加操作："+(over-begin)+"毫秒");
//        }

    private static int time = 50000;
    public static void main(String[] args) {
//        testString();
//        testOptimalString();
        String a = "hello";
        String b =  new String("hello");
        String c =  new String("hello");
        String d = b.intern();

        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(b==d);
        System.out.println(a==d);

    }


    public static void testString () {
        String s="";
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            s += "java";
        }
        long over = System.currentTimeMillis();
        System.out.println("操作"+s.getClass().getName()+"类型使用的时间为："+(over-begin)+"毫秒");
    }

    public static void testOptimalString () {
        String s="";
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            StringBuilder sb = new StringBuilder(s);
            sb.append("java");
            s=sb.toString();
        }
        long over = System.currentTimeMillis();
        System.out.println("模拟JVM优化操作的时间为："+(over-begin)+"毫秒");
    }





}
