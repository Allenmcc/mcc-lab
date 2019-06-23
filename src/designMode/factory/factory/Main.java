package designMode.factory.factory;

/**
 * Created by chunchen.meng on 2019/6/21.
 * https://mp.weixin.qq.com/s?__biz=MzI4Njg5MDA5NA==&mid=2247484243&idx=1&sn=972cbe6cdb578256e4d4771e7ca25de3&chksm=ebd74252dca0cb44419903758e8ca52d9ab287562f80be9365e305d6dcc2deaa45b40f9fd2e9&scene=21#wechat_redirect
 */
public class Main {

    /**
     * 优点
     * 1:客户端不需要在负责对象的创建,明确了各个类的职责
       2:如果有新的对象增加,只需要增加一个具体的类和具体的工厂类即可
       3:不会影响已有的代码,后期维护容易,增强系统的扩展性
     缺点
     1:需要额外的编写代码,增加了工作量
     * @param args
     */

    public static void main(String[] args) {

        // 去找狗工厂拿一只狗过来
        AnimalFactory f = new DogFactory();

        // 店主就拿到了一只狗给Java3y
        Animal a = f.createAnimal();
        a.eat();
        System.out.println("关注公众号：Java3y");


        // 去找猫工厂拿一只猫过来
        AnimalFactory ff = new CatFactory();

        // 店主就拿到了一只猫给Java3y
        Animal aa = ff.createAnimal();
        aa.eat();
        System.out.println("关注公众号：Java3y");

    }
}
