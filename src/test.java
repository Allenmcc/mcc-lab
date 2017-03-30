/**
 * Created by danny on 15/10/28.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class test {
    public static void main(String[] args) {

        TreeSet ts = new TreeSet();
        String keywordStr = "2000以下+婚宴";
        String[] keywordArr = keywordStr.split("\\+");
        for (String str:keywordArr){ ts.add(str);
        }
//System.out.println(ts);
        for(Object pram : ts){
            System.out.print(pram.toString()+"+");
        }
//        String str = "abcdefg";
//
//        for (int i = 0 ;i< str.length();i++){
//
//            System.out.println(str.charAt(i)+"\t");
//        }
//        System.out.println("截取最后一个字符串生成的新字符串为: " + str.substring(0,str.length()-1));

//        List<Integer> list = new ArrayList<Integer>();
//        for(int i=0;i<10;i++)
//            list.add(i);
//        System.out.println(list);
//        list.clear();
//        System.out.println(list);


    }
}
