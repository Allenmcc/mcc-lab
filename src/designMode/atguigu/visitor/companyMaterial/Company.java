package designMode.atguigu.visitor.companyMaterial;/**
 * Created by winwin on 2021/8/15.
 */

/**
 * Created by allen
 */
//抽象访问者:公司
public interface Company {

    String create(Paper element);

    String create(Cuprum element);
}
