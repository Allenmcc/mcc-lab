package designMode.atguigu.visitor.companyMaterial;/**
 * Created by winwin on 2021/8/15.
 */

/**
 * Created by allen
 */
//抽象元素：材料
//比较稳定的数据结构
public interface Material {

    String accept(Company visitor);
}
