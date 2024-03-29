package designMode.atguigu.state.thread;

/**
 * 环境类（ThreadContext）中先生成一个初始状态（New）
 */
public class ThreadContext {

    private ThreadState state;
    ThreadContext() {
        state = new New();
    }
    public void setState(ThreadState state) {
        this.state = state;
    }
    public ThreadState getState() {
        return state;
    }
    public void start() {
        ((New) state).start(this);
    }
    public void getCPU() {
        ((Runnable) state).getCPU(this);
    }
    public void suspend() {
        ((Running) state).suspend(this);
    }
    public void stop() {
        ((Running) state).stop(this);
    }
    public void resume() {
        ((Blocked) state).resume(this);
    }
}
