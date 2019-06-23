package designMode.factory.factory;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
//多态
public class Cat extends Animal {
    // 猫喜欢吃鱼
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
