package designMode.atguigu.visitor.companyMaterial;/**
 * Created by winwin on 2021/8/15.
 */

/**
 * Created by allen
 */
//具体访问者：艺术公司
public class ArtCompany implements Company {

    @Override
    public String create(Paper element) {
        System.out.println("讲学图:" + element.paperOpetion());
        return "讲学图";
    }

    @Override
    public String create(Cuprum element) {
        System.out.println("朱熹铜像:" + element.cuprumOpetion());
        return "朱熹铜像";

    }
}
