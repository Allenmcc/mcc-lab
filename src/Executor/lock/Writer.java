package Executor.lock;

/**
 * Created by chunchen.meng on 2018/10/29.
 */
public class Writer extends Thread{
//    private Buffer buff;

    private BufferInterruptibly buff;

//    public Writer(Buffer buff) {
    public Writer(BufferInterruptibly buff) {
        this.buff = buff;
    }

    @Override
    public void run() {
        buff.write();
    }
}
