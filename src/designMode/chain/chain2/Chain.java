package designMode.chain.chain2;

import java.util.List;

/**
 * Created by chunchen.meng on 2019/6/20.
 */
public class Chain {
    //同chain1 的区别
    //将各个handler保存在handlers这个list中
    //各个handler之间的执行顺序由chain来维持
    private List<ChainHandler> handlers;
    private int index = 0;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void proceed() {
        if (index >= handlers.size()) {
            return;
        }
        handlers.get(index++).execute(this);
    }
}
