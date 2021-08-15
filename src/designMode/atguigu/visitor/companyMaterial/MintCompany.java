package designMode.atguigu.visitor.companyMaterial;/**
 * Created by winwin on 2021/8/15.
 */

/**
 * Created by allen
 */
//造币公司
public class MintCompany implements Company {

    @Override
    public String create(Paper element) {
        System.out.println("纸币:" + element.paperOpetion());
        return "纸币";
    }

    @Override
    public String create(Cuprum element) {
        System.out.println("铜币:" + element.cuprumOpetion());
        return "铜币";
    }
}
