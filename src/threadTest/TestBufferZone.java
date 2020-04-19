package threadTest;

//线程同步
//生产者消费者模型->利用缓冲区解决:管程法
//生产者，消费者，产品，缓冲区
/**
 * 并发协作模型"生产者/消费者模式"---->管程法
 * 生产者:负责生产数据的模块(可能是方法，对象，线程，进程)
 * 消费者:负责处理数据的模块(可能是方法，对象，线程，进程)
 * 缓冲区:消费者不能直接使用生产者的数据，他们之间有个缓冲区
 * 生产者将生产好的数据放入缓冲区，消费者从缓冲区中拿出数据
 */
public class TestBufferZone {


    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Productor extends Thread{
    SynContainer synContainer;

    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    //生产
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");

        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    //消费者
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+i+"只鸡");
        }
    }
}

//产品
class Chicken{
    int id; //产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer{

    //需要一个容器大小 缓冲区
    Chicken[] chickens = new Chicken[10];

    //容器计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){

        //如果容器满了，就需要等待消费者消费
        if(count == chickens.length){
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果没有满，我们就需要丢入产品
        chickens[count] = chicken;
        count++;

        //可以通知消费者消费了。
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken  pop(){
        //判断能否消费
        if(count == 0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];

        //吃完了，通知生产者生产
        return chicken ;
    }
}