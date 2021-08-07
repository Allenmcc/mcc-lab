package designMode.atguigu.factory.absfactory.medicalstore.order;

import designMode.atguigu.factory.absfactory.medicalstore.good.IMask;
import designMode.atguigu.factory.absfactory.medicalstore.good.IProtectiveSuit;
import designMode.atguigu.factory.absfactory.medicalstore.good.LowEndMask;
import designMode.atguigu.factory.absfactory.medicalstore.good.LowEndProtectiveSuit;

/**
 * 低端端工厂  口罩，防护服是一个产品族，不同产品等级
 */
public class LowEndFactory implements IFactory {
    @Override
    public IMask createMask() {
        IMask mask =  new LowEndMask();
        // .....
        //  LowEndMask的100行初始化代码
        return mask;
    }

    @Override
    public IProtectiveSuit createSuit() {
        IProtectiveSuit suit =  new LowEndProtectiveSuit();
        // .....
        //  LowEndProtectiveSuit的100行初始化代码
        return suit;
    }


}
