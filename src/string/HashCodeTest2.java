package string;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by chunchen.meng on 2018/11/28.
 */
public class HashCodeTest2 {
    public static void main(String[] args) {
        Collection set = new HashSet();
        Point2 p1 = new Point2(1, 1);
        Point2 p2 = new Point2(1, 2);

        set.add(p1);
        set.add(p2);

        p2.setX(3);
        p2.setY(3);

        set.remove(p2);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object);
        }
    }
}

class Point2 {
    private int x;
    private int y;

    public Point2(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point2 other = (Point2) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "x:" + x + ",y:" + y;
    }
}
