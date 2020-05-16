package atomic;

public class ReSortTestTest {

     int a=0;
      boolean flag = false;

      //禁止指令重排
//    volatile int a=0;
//    volatile  boolean flag = false;

    public void method1(){
        a = 1;  //语句1
        flag = true; //语句2    //无依赖性，可能2先执行
    }

    //多线程环境中线程交替执行，由于编辑器优化重排的存在，
    //两个线程中使用的变量能否保证一致性是无法确定的，结果无法预测
    public void method2(){
        if (flag){
            a = a+5;  //语句3
            System.out.println("reValue："+a);
        }
    }
}
