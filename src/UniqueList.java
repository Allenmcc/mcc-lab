import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by danny on 16/1/7.
 */


public class UniqueList {

    public  static void main(String arg[]) {
        List<Person> list = new ArrayList<Person>();
        Person a = new Person();
        a.id = 1;
        a.age = 10;
        Person b = new Person();
        b.id = 1;
        b.age = 10;
        Person c = new Person();
        c.id = 2;
        c.age = 10;
        Person d = new Person();
        d.id = 2;
        d.age = 10;
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        List<Person>  tempList = new ArrayList<Person>();

        for (Person i : list) {
            System.out.println(i.id);
        }



        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for(int i=0;i<list.size();i++){
            if(map.get(list.get(i).id)!=null){
                list.remove(i);
                i--;
            }
            else {
                map.put(list.get(i).id, "OK");
            }
        }



        System.out.println(list.size());
        //虽然内容相同，但是也是加进去，
        for (Person i : list) {
            System.out.println(i.id);
        }
//        for (Person i : list) {
//            if(!tempList.contains(i))
//                tempList.add(i);
//        }
//
//        for (Person i : tempList) {
//            System.out.println(i.id);
//        }


//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(4);
//        list.add(1);
//        list.add(2);
//        list.add(5);
//        list.add(1);
//        List<Integer> tempList = new ArrayList<Integer>();
//        for (Integer i : list) {
//            if (!tempList.contains(i)) {
//                tempList.add(i);
//            }
//        }
//        for (Integer i : tempList) {
//
//            System.out.println(i);
//        }

    }
}
