/**
 * Created by danny on 16/8/5.
 */


public class TicketSafety extends Thread {
    private int threadNo;
    public TicketSafety(int threadNo) {
        this.threadNo = threadNo;
    }
    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 10; i++) {
            new TicketSafety(i).start();
            Thread.sleep(1);
        }
    }

    @Override
    public synchronized void run() {
        for (int i = 1; i < 20; i++) {
            System.out.println("窗口:" + threadNo + ":" + i);
        }
    }
}