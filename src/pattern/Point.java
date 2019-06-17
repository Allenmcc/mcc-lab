package pattern;

/**
 * Created by chunchen.meng on 2017/11/25.
 */
public class Point<T1,T2> {
    T1 x;
    T2 y;
    public T1 getX() {
        return x;
    }
    public void setX(T1 x) {
        this.x = x;
    }
    public T2 getY() {
        return y;
    }
    public void setY(T2 y) {
        this.y = y;
    }


    //范型方法里面的类型参数可以不是T1,T2
    public <E1,E2>void printPoint(E1 x,E2 y){
        E1 m = x;
        E2 n = y;
        System.out.println("printPoint is "+m+","+n);


    }
}
