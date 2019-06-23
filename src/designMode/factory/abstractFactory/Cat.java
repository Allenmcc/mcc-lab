package designMode.factory.abstractFactory;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
public abstract class Cat extends Animal{

    // 猫喜欢吃鱼
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

}
