package designMode.atguigu.factory.absfactory.medicalstore.order;

import designMode.atguigu.factory.absfactory.medicalstore.good.IMask;
import designMode.atguigu.factory.absfactory.medicalstore.good.IProtectiveSuit;


/**
 * https://zhuanlan.zhihu.com/p/243277598
 * 口罩，防护服是一个产品族，不同产品等级
 */
public interface IFactory {

    //创建口罩
    IMask createMask();
    //创建防护服
    IProtectiveSuit createSuit();
}
