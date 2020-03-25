package spring;

import org.springframework.data.util.Pair;

public class PairTest {


    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1,"a");
        System.out.println(pair.getFirst());

    }


}
