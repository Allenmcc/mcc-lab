package Pattern;

/**
 * Created by chunchen.meng on 2017/11/25.
 */
public class PatternTest {
    public static void main(String[] args){
        // 实例化泛型类
        Point<Integer, Integer> p1 = new Point<Integer, Integer>();
        p1.setX(10);
        p1.setY(20);
        int x = p1.getX();
        int y = p1.getY();
        System.out.println("This point is：" + x + ", " + y);

        Point<Double, String> p2 = new Point<Double, String>();
        p2.setX(25.4);
        p2.setY("东京180度");
        double m = p2.getX();
        String n = p2.getY();
        System.out.println("This point is：" + m + ", " + n);
        p2.printPoint(m,n);
    }
}
