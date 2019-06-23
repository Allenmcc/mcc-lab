package designMode.strategy;

/**
 * Created by chunchen.meng on 2019/6/21.
 * https://segmentfault.com/a/1190000017549609
 */
public class Main {
    public static void main(String[] args) {


        /**
         * 如果没有上下文的话，客户端就必须直接和具体的策略实现进行交互了，尤其是需要提供一些公共功能或者是存储一些状态的时候，会大大增加客户端使用的难度；
         * 引入上下文之后，这部分工作可以由上下文来完成，客户端只需要和上下文进行交互就可以了。这样可以让策略模式更具有整体性，客户端也更加的简单。
         *
         * 上层模块必须知道有哪些策略，然后才能决定使用哪一个策略。
         */
        // 今天2018年12月24日
        ////不直接通过 WaterArmy w= new WaterArmy() ; w.action();
        //通过Java3y来调用更加符合面向对象（屏蔽了直接对具体对象对访问）
        Java3y java3y = new Java3y(new WaterArmy());
        java3y.exec();

        // 明天2018年12月25日
        Java3y java4y = new Java3y(new OriginalArticle());
        java4y.exec();

        // ......
    }
}
