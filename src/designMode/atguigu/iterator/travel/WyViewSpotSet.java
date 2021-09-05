package designMode.atguigu.iterator.travel;

import java.util.ArrayList;

/**
 * Created by allen
 *
 * 具体聚合：婺源景点集
 */
public class WyViewSpotSet implements ViewSpotSet{

    private ArrayList<WyViewSpot> list = new ArrayList<WyViewSpot>();


    @Override
    public void add(WyViewSpot obj) {
        list.add(obj);

    }

    @Override
    public void remove(WyViewSpot obj) {
        list.remove(obj);

    }

    @Override
    public ViewSpotIterator getIterator() {
        return (new WyViewSpotIterator(list));
    }
}
