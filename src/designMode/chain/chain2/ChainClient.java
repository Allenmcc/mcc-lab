package designMode.chain.chain2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chunchen.meng on 2019/6/20.
 */
public class ChainClient {
    static class ChainHandlerA extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by a");
        }
    }
    static class ChainHandlerB extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by b");
        }
    }
    static class ChainHandlerC extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by c");
        }
    }

    public static void main(String[] args) {
        /**
         在list中的顺序决定了handler的执行顺序
         */
        List<ChainHandler> handlers = Arrays.asList(
                new ChainHandlerA(),
                new ChainHandlerB(),
                new ChainHandlerC()
        );

        Chain chain = new Chain(handlers);
        chain.proceed();
    }
}
