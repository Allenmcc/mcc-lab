package designMode.atguigu.factory.absfactory.product;

/**
 * 抽象工厂：
 * 一个工厂可以生产不同等级的产品：比如海尔可以生产电视 ，空调
 * 海尔电视和TCL电视 属于一个产品等级
 *
 * 抽象工厂模式通常适用于以下场景：
 * 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。
 * 系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。
 * 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。
 */

public interface AbstractFactory {

    public Product1 newProduct1();

    public Product2 newProduct2();
}
