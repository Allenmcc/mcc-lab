package loader;

/**
 * Created by chunchen.meng on 2018/11/21.
 */
public class Test12 {
    public void hello() {
        System.out.println("恩，是的，我是由 " + getClass().getClassLoader().getClass()
                + " 加载进来的");
    }
}
