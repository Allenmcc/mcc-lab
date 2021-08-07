package designMode.atguigu.factory.absfactory.medicalstore.order;

import designMode.atguigu.factory.absfactory.medicalstore.good.HighEndMask;
import designMode.atguigu.factory.absfactory.medicalstore.good.HighEndProtectiveSuit;
import designMode.atguigu.factory.absfactory.medicalstore.good.IMask;
import designMode.atguigu.factory.absfactory.medicalstore.good.IProtectiveSuit;


/**
 * 高端工厂  口罩，防护服是一个产品族，不同产品等级
 */
public class HighEndFactory implements IFactory {
    @Override
    public IMask createMask() {
        IMask mask =  new HighEndMask();
        // .....
        // HighEndMask的100行初始化代码
        return mask;
    }

    @Override
    public IProtectiveSuit createSuit() {
        IProtectiveSuit suit =  new HighEndProtectiveSuit();
        // .....
        //  HighEndProtectiveSuit的100行初始化代码
        return suit;
    }




}
