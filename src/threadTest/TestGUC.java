package threadTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//测试guc安全类型的集合
public class TestGUC {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> list.add(Thread.currentThread().getName())).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }


    /**
     * ArrayList是线程不安全
     * https://blog.csdn.net/u012859681/article/details/78206494
     */
    @Test
    public void testUnSafeList(){
//        ArrayList 线程不安全
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 100000; i++) {
//            new Thread(() -> list.add(Thread.currentThread().getName())).start();
//        }

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        System.out.println(list.size());

        final List<Integer> list = new ArrayList<Integer>();

        // 线程A将0-1000添加到list
        //问题 多试几次 java.lang.ArrayIndexOutOfBoundsException:
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000 ; i++) {
                    list.add(i);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 线程B将1000-2000添加到列表
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1000; i < 2000 ; i++) {
                    list.add(i);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印所有结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }

    }
}
