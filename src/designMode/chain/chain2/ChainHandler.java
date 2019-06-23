package designMode.chain.chain2;

/**
 * Created by chunchen.meng on 2019/6/20.
 */
public abstract class ChainHandler {
    public void execute(Chain chain) {
        handleProcess();
        chain.proceed();
    }

    protected abstract void handleProcess();
}
