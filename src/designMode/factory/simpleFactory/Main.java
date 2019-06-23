package designMode.factory.simpleFactory;

import designMode.factory.factory.Animal;

/**
 * Created by chunchen.meng on 2019/6/21.
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        // 拿到狗
        Animal A = AnimalFactory.createAnimal("dog");
        A.eat();

        // 拿到猫
        Animal C = AnimalFactory.createAnimal("cat");
        C.eat();
    }
}
