package threadTest;

/**
 * 产生死锁的四个必要条件：
 * 1.互斥条件：一个资源每次只能被一个进程使用
 * 2.请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放
 * 3.不剥夺条件：进程已获得资源，在未使用完之前，不能强行剥夺。
 * 4.循环等待条件：若干进程之间形成一个头尾相接的循环等待资源关系
 * 上面列出的四个必要条件，我们只要想办法破其中任意一个或者多个条件就能避免死锁发生
 */
//死锁:多个线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {

    public static void main(String[] args) {

      MakeUp g1 = new MakeUp(0,"灰姑凉");
      MakeUp g2 = new MakeUp(1,"白雪公主");

      g1.start();
      g2.start();

    }


}

//口红
class Lipsick{

}

//镜子
class Mirror{

}

//需要的资源只有一份，用static 保证只有一份
class MakeUp extends Thread{
    static  Lipsick lipsick = new Lipsick();
    static  Mirror mirror = new Mirror();

    int choice;
    String girlName;

     MakeUp( int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
       //化妆
//        makeup();
        makeupSafe();
    }

    //化妆，互相持有对方的锁，就是需要拿到对方的锁
    private void makeup(){

         if (choice == 0){
             synchronized (lipsick){
                 System.out.println(this.girlName+ "获得口红的锁");
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 synchronized (mirror){
                     System.out.println(this.girlName+"获得镜子的锁");
                 }
             }
         }else {
             synchronized (mirror){
                 System.out.println(this.girlName+"获得镜子的锁");
                 try {
                     Thread.sleep(2000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 synchronized (lipsick){
                     System.out.println(this.girlName+"获得口红的锁");
                 }
             }
         }
    }

    private void makeupSafe(){

        if (choice == 0){
            synchronized (lipsick){
                System.out.println(this.girlName+ "获得口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (lipsick){
                System.out.println(this.girlName+"获得口红的锁");
            }
        }
    }
}
