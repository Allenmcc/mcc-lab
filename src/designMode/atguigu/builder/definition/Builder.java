package designMode.atguigu.builder.definition;


/**
 * Created by allen
 */

//抽象建造者：包含创建产品各个子部件的抽象方法。
public abstract class Builder {

    //创建产品对象  protected 子类&同包朋友类可以直接访问（类public），不需要get public 方法
    //组合
    protected Product product = new Product();
//    protected Product product;  //error 产品需要初始化，子类要使用其方法
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    //返回产品对象
    public Product getResult() {
        return product;
    }
}
