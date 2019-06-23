package designMode.factory.factory;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
// 继承着宠物工厂
public class CatFactory implements AnimalFactory {

    @Override
    // 创建猫
    public Animal createAnimal() {
        return new Cat();
    }
}
