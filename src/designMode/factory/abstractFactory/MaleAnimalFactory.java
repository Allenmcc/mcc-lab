package designMode.factory.abstractFactory;

/**
 * Created by chunchen.meng on 2019/6/21.
 */

//抽象工厂是创建出一类产品
public class MaleAnimalFactory implements AnimalFactory{

    // 生产公狗和公猫
    @Override
    public Animal createDog() {
        return new MaleDog();
    }

    @Override
    public Animal createCat() {
        return new MaleCat();
    }
}
