package designMode.factory.factory;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
// 号称什么宠物都有
public interface AnimalFactory {

    // 可以获取任何的宠物
    Animal createAnimal();
}
