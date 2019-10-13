package stringTest;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

public class ArrayStringTest {

    public static void main(String[] args) {
        List<String> strings = Lists.newArrayList("1","2","3");
        String string = "1,2,3";

        String[] strings1 = new String[strings.size()];
        String[] strings2 = strings.toArray(strings1);
        //引用传递
        strings2[1] = "22";
        System.out.println("list->Array"+strings1);


        List<String> list = Arrays.asList(strings1);
        list.stream().forEach(p->
            System.out.println(p)
        );
        list.forEach(p->{
            System.out.println(p);
        });

        //array -> 逗号相隔字符串
        String s = StringUtils.join(strings1, ',');
       System.out.println(s);

    }
}
