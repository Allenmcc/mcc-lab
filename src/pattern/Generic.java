package pattern;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by chunchen.meng on 2019/2/21.
 * 泛型类
 * 定义
 * 泛型是加在类型名后面
 * <>里面的东西就是泛型的形参，名字要只要遵循java标识符规范就行
 * 通常泛型用大写字符T,E
 * 泛型可以理解为Object
 */
public class Generic<T extends Number> {

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }

    public static void showKeyValue1(Generic<? extends Number> obj){
        System.out.println(obj.getKey());
    }

    ////泛型方法的泛型是加在返回类型前面
    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
   //public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
    public <T extends Number> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }

    public static void main(String[] args) {
//        Generic<String> generic1 = new Generic<String>("11111");
        Generic<Integer> generic2 = new Generic<Integer>(2222);
        Generic<Float> generic3 = new Generic<Float>(2.4f);
        Generic<Double> generic4 = new Generic<Double>(2.56);

//这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
//        showKeyValue1(generic1);

        showKeyValue1(generic2);
        showKeyValue1(generic3);
        showKeyValue1(generic4);

        List<? extends String> names = Lists.newArrayList("yiifaa");
        //  声明消费者
        List<String> allNames = Lists.newArrayList("yiifee");
        //  消费生产者的元素
        allNames.addAll(allNames);

    }

}
