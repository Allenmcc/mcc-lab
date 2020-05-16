//package atomic;
//
//public class ReOrderTest {
//
//    public static void main(String[] args) {
//        final int[] a = {0};
//        final int[] b = {0};
//        final int[] x = {0};
//        final int[] y = {0};
//        new Thread(()->{
//            try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
//            x[0] =a[0];
//            b[0] =1 ;
//        },"t1").start();
//
//        new Thread(()->{
////            try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
//
//            y[0] =b[0];
//            a[0] =2 ;
//        },"t2").start();
//
//
//        System.out.println("x is:"+x[0]);
//        System.out.println("y is:"+y[0]);
//    }
//}
