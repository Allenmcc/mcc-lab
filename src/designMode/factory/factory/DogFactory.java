package designMode.factory.factory;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
// 继承着宠物工厂
public class DogFactory implements AnimalFactory {
    // 创建狗
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
