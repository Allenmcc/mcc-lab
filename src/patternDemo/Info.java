package patternDemo;

/**
 * Created by danny on 2017/2/14.
 * 泛型接口
 *
 *接口里面常量都是public static final，而且要明确给值
 *接口所有方法都是public abstract 抽象方法
 */
public interface Info<T> {

    public T getVar();
//    接口里面常量都是public static final，而且要明确给值
    int i = 10;

}
