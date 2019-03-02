package threads.singleThreadedExecution;

/**
 * Created by chunchen.meng on 2019/2/12.
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    //1.synchronized 保护了啥（3个参数）
    //2.其他地方也保护了吗 （toString(),check）
    public synchronized void  pass(String name, String address) {
        System.out.println("pass method" +"name: "+this.name + " address: "+this.address );
        this.counter++;
        this.name = name;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        this.address = address;
        check();
    }


    //synchronized public 方法，外部有可能多线程读取保护的counter，name，address
    @Override
    public synchronized String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }




    // 私有方法，外部不可以读取，无需synchronized
    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ***** " + toString());
        }
    }
}

