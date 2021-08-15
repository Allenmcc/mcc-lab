package designMode.atguigu.visitor.companyMaterial;/**
 * Created by winwin on 2021/8/15.
 */

/**
 * Created by allen
 */
public class Paper implements Material {

    @Override
    public String accept(Company visitor) {
        return (visitor.create(this));
    }

    public String paperOpetion() {
        return "具体元素纸的操作。";
    }
}
