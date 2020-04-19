package threadTest;

//观察线程状态
public class TestThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("current state:"+ Thread.currentThread().getName()+":"+Thread.currentThread().getState());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("over");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(thread.getName()+":1"+ state); //new


        //观察启动后
        thread.start();  //启动线程
        state = thread.getState();
        System.out.println(thread.getName()+":2"+state); //RUNNABLE

        while (state != Thread.State.TERMINATED){

            Thread.sleep(500);
            state = thread.getState(); //更新线程状态
            System.out.println(thread.getName()+":3"+ state); //输出状态 结束后TERMINATED
        }
    }
}
