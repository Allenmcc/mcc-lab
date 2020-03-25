package listTest;

import java.util.*;

/**
 * Created by danny on 16/1/7.
 */


public class UniqueList {

    public  static void main(String arg[]) {


        List<Integer> errors= Arrays.asList(1,2,3,4,5);
        errors.forEach(p->{
            try {
                if(p.equals(2)){
                    int aa = 3/0;
                }
            }catch (Exception e){
//                throw  new RuntimeException();
                System.out.println("error");
            }

            System.out.println(p);
        });

        List<Person> list = new ArrayList<Person>();
        Person a = new Person();
        a.id = 1;
        a.age = 10;
        Person b = new Person();
        b.id = 1;
        b.age = 10;

        list.add(a);
        list.add(b);

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 1;
            }
        });

        Collections.sort(list, (o1, o2) ->
              o1.getAge().compareTo(o2.getAge())
        );
//        list.forEach(person -> System.out.println(person.id));
        list.stream().forEach(person -> System.out.println(person.getId()));

//        listTest.Person c = new listTest.Person();
//        c.id = 2;
//        c.age = 10;
//        listTest.Person d = new listTest.Person();
//        d.id = 2;
//        d.age = 10;
//        list.add(a);
//        list.add(b);
//        list.add(c);
//        list.add(d);
//        List<listTest.Person>  tempList = new ArrayList<listTest.Person>();
//
//        for (listTest.Person i : list) {
//            System.out.println(i.id);
//        }


//
//        HashMap<Integer, String> map = new HashMap<Integer, String>();
//        for(int i=0;i<list.size();i++){
//            if(map.get(list.get(i).id)!=null){
//                list.remove(i);
//                i--;
//            }
//            else {
//                map.put(list.get(i).id, "OK");
//            }
//        }

//        System.out.println(map);

        HashMap<String, Person> mapPerson = new HashMap<String, Person>();
        mapPerson.put("aa",a);
        mapPerson.put("bb",b);



        System.out.println(mapPerson);
        System.out.println(mapPerson.get("aa"));
        System.out.println(mapPerson.get("aa").getId());




        // 强引用 ，即使删除了a ，但其实对象在堆里还在。并且 mapPerson 还在，因此mapPerson.get("aa") 还在
        a = null;
//        a.id =25;

        System.out.println(mapPerson);
        System.out.println(mapPerson.get("aa").getId());
        System.out.println("a:"+a);


//        System.out.println(list.size());
        //虽然内容相同，但是也是加进去，
//        for (listTest.Person i : list) {
//            System.out.println(i.id);
//        }
//        for (listTest.Person i : list) {
//            if(!tempList.contains(i))
//                tempList.add(i);
//        }
//
//        for (listTest.Person i : tempList) {
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
