package designMode.factory.abstractFactory;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
public class Main {
    public static void main(String[] args) {


        // 需要性别为母的就去找母工厂
        AnimalFactory af = new FemaleAnimalFactory();

        // 需要一只母猫
        af.createCat().gender();

        // 需要一只母狗
        af.createDog().gender();

        System.out.println("-------------关注公众号：Java3y-------------------------");

        // 需要性别为公的就去找公工厂
        AnimalFactory aff = new MaleAnimalFactory();

        // 需要一只公狗
        aff.createDog().gender();

        // 需要一只公猫
        aff.createCat().gender();

    }
}
