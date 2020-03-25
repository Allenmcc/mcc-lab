package patternDemo;

/**
 * Created by danny on 2017/2/14.
 * 实现类
 * 接口处没有明确泛型类型，实现类必须<T>,泛型类
 * 类型指定了，类就不用指定
 */
//实现接口
public class InfoImp2 implements Info<String> {
    private String var;
    // 定义泛型构造方法
    public InfoImp2(String var) {
        this.setVar(var);
    }
    public void setVar(String var) {
        this.var = var;
    }
    @Override
    public String getVar() {
        return this.var;
    }
}