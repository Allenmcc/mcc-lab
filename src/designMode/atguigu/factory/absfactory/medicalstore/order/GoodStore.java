package designMode.atguigu.factory.absfactory.medicalstore.order;

import designMode.atguigu.factory.absfactory.medicalstore.good.IMask;
import designMode.atguigu.factory.absfactory.medicalstore.good.IProtectiveSuit;

public class GoodStore {


//    实例化不同的工厂子类，调用不同的创建方法，可以创建出不同的产品
    public static void main(String[] args) {
        IFactory factoryA = new LowEndFactory();
        IFactory factoryB = new HighEndFactory();
        //创建低端口罩
        IMask maskA = factoryA.createMask();
        //创建高端口罩
        IMask maskB = factoryB.createMask();
        //创建低端防护服
        IProtectiveSuit suitA = factoryA.createSuit();
        //创建高端防护服
        IProtectiveSuit suitB = factoryB.createSuit();

        maskA.showMask();
        maskB.showMask();
        suitA.showSuit();
        suitB.showSuit();


    }
}
