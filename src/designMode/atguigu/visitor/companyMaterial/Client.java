package designMode.atguigu.visitor.companyMaterial;/**
 * Created by winwin on 2021/8/15.
 */

/**
 * Created by allen
 */
public class Client {

    public static void main(String[] args) {
        SetMaterial setMaterial = new SetMaterial();
        setMaterial.add(new Paper());
        setMaterial.add(new Cuprum());

        //访问者 艺术公司
        System.out.println(" ==========访问者 艺术公司=============");
        setMaterial.accept(new ArtCompany());


        System.out.println(" ==========访问者 造币公司==========");
        //访问者 造币公司
        setMaterial.accept(new MintCompany());
    }
}
