package patternDemo;

/**
 * Created by danny on 2017/2/14.
 * 实现类
 * 接口处没有明确泛型类型，实现类必须<T>,泛型类
 */
//实现接口
public class InfoImp<T> implements Info<T> {
    private T var;
    // 定义泛型构造方法
    public InfoImp(T var) {
        this.setVar(var);
    }
    public void setVar(T var) {
        this.var = var;
    }

    //泛型方法的泛型是加在返回类型前面
    @Override
    public T getVar() {
        return this.var;
    }
}