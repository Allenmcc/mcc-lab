package threads;

/**
 * Created by chunchen.meng on 2019/2/12.
 */
public class PrintThread extends Thread {

    private String message;
    public PrintThread(String message){
        this.message = message;

    }

    @Override
    public void run() {
       for (int i = 0;i<1000;i++){
           System.out.print(message);
       }
    }

    public static void main(String[] args) {
        new PrintThread("*").start();
        new PrintThread("+").start();

        new PrintThread("*").run();
        new PrintThread("+").run();
    }
}
