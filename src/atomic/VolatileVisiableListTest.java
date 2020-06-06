package atomic;


import java.util.ArrayList;
import java.util.List;

public class VolatileVisiableListTest {
    //提供一个容器
//     List list = new ArrayList();  //多跑几次还是会结束
  volatile   List list = new ArrayList();
    //这是一个add方法
    public void add(Object o){
        list.add(o);
    }
    //这是一个size方法
    public int size(){
        return list.size();
    }
    public static void main(String[] args) {
        VolatileVisiableListTest wVolatile = new VolatileVisiableListTest();
        //新建一个线程B,用于监控容器的个数
        new Thread(()->{
            while(true){
                if(wVolatile.size()==5){
                    break;
                }
            }
            System.out.println("线程t2 结束");
        },"t2").start();
        //这是一个线程A,添加Object到容器中
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                wVolatile.add(new Object());
                System.out.println("add "+i);
            }
        },"t1").start();
    }
}


