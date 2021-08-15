package designMode.atguigu.visitor.companyMaterial;/**
 * Created by winwin on 2021/8/15.
 */

/**
 * Created by allen
 */
//具体元素：铜
public class Cuprum implements Material{

    @Override
    public String accept(Company visitor) {
        return (visitor.create(this));
    }

    public String cuprumOpetion() {
        return "具体元素铜的操作。";
    }
}
