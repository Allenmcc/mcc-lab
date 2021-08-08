package designMode.atguigu.state.define;

/**
 * http://c.biancheng.net/view/1388.html
 */
public class StatePatternClient {

    public static void main(String[] args) {
        Context context = new Context();    //创建环境
        context.Handle();    //处理请求
        context.Handle();
        context.Handle();
        context.Handle();
    }
}
