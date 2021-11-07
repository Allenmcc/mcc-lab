package designMode.atguigu.builder.definition;

/**
 * Created by allen
 */

/**
 * 指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，
 * 在指挥者中不涉及具体产品的信息。
 */
//指挥者：调用建造者中的方法完成复杂对象的创建。
public class Director {

    //聚合依赖关系
    private Builder builder;

    //构造函数初始化
    public Director(Builder builder) {
        this.builder = builder;
    }

    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
