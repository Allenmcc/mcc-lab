package designMode.atguigu.iterator.travel;

/**
 * Created by allen
 * 设计一个婺源景点（WyViewSpot）类来保存每张图片的名称与简介；再设计一个景点集（ViewSpotSet）接口，
 * 它是抽象聚合类，提供了增加和删除婺源景点的方法，以及获取迭代器的方法。
 */
//婺源景点类
public class WyViewSpot {
    private String Name;
    private String Introduce;

    WyViewSpot(String Name, String Introduce) {
        this.Name = Name;
        this.Introduce = Introduce;
    }

    public String getName() {
        return Name;
    }

    public String getIntroduce() {
        return Introduce;
    }
}
