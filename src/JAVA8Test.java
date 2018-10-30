import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by chunchen.meng on 2017/11/1.
 */
public class JAVA8Test {

    public static void main(String args[]){

//        List<String> output = wordList.stream().
//                map(String::toUpperCase).
//                collect(Collectors.toList());

//        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> nums = new ArrayList<>();
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).filter(p->p.equals(2)).
                collect(Collectors.toList());

//        Stream.of(nums).map(n -> n * n).collect(Collectors.toList());


        System.out.println(squareNums.size());

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());

//       System.out.println(outputStream.mapToInt(n->n).sum());

       System.out.println(outputStream.collect(Collectors.toList()));

//       System.out.println(outputStream.collect(Collectors.toSet()));

//       System.out.println(outputStream.collect(Collectors.joining()).toString());

//       System.out.println(outputStream.collect(Collectors.toCollection(ArrayList::new)));

//        outputStream.forEach(System.out::println);

        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens =
                Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);

        System.out.println(evens.length);


        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .peek(e -> System.out.println("test value: " + e))
                .collect(Collectors.toList());


        List<Integer> test = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);

        System.out.println("sum is:"+test.stream().filter(num -> num != null).

        distinct().mapToInt(num -> num * 2).

        peek(System.out::println).skip(2).limit(4).sum());






    }
}
