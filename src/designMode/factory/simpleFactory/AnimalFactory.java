package designMode.factory.simpleFactory;

import designMode.factory.factory.Animal;
import designMode.factory.factory.Cat;
import designMode.factory.factory.Dog;

/**
 * Created by chunchen.meng on 2019/6/21.
 *
 * 1:我想要一个猪,可是我的工厂类没有猪
 2:我就去改代码,写可以创建猪对象的
 3:接着,我又要其他的动物
 4:我还是得改代码
 5……………….
 6:这就是简单工厂类的缺点：当需求改变了,我就要改代码.
 优点：简单工厂类的优点也很明显：我就一个具体的工厂来创建对象，代码量少。
 *
 */
public class AnimalFactory {
    public static Dog createDog() {
        return new Dog();
    }

    public static Cat createCat() {
        return new Cat();
    }


    // 外界想要猫要狗，这里创建就好了
    public static Animal createAnimal(String type) {
        if ("dog".equals(type)) {
            return new Dog();
        } else if ("cat".equals(type)) {
            return new Cat();
        } else {
            return null;
        }
    }
}
