package interfaceTest;

/**
 * Created by chunchen.meng on 2018/10/1.
 */
public class UseCompute {

    /**
     *  接口作为参数传递
     * 接口的作用有两个：约定功能和隐藏实现
     * 一个方法声明以接口作为参数，那么这个方法只能接受这个接口的实现类（入参）。
     * 这样做的好处是提高代码复用性，简化逻辑编写，降低耦合度。
     * 编写该方法是，只需关注接口提供的功能，而不用关系接口如何实现。
     * 这种设计模式对于大规模的软件项目的设计、编写、管理、维护是有利的。
     */

    public void useCom(Compute com, int one, int two)
    {
        /**
         * 编写该方法是，只需关注接口提供的功能，而不用关系接口如何实现。
         * 方法提供计算功能，不用关注实现
         */
        System.out.println(com.computer(one, two));
    }
}
