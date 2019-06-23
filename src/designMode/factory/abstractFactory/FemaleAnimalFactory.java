package designMode.factory.abstractFactory;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
public class FemaleAnimalFactory implements AnimalFactory {

    // 生产母狗和母猫
    @Override
    public Animal createDog() {
        return  new FemaleDog();
    }

    @Override
    public Animal createCat() {
        return new FemaleCat();
    }

}
