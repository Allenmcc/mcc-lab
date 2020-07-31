package spring;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;


/**
 * 有时候我们调用方法的时候返回值有可能不止1个，比如说我们返回name = "张三" age = 20这两个值，那么这个时候方法的返回值怎么写呢。在Scala和python中都有Tuple使用，在java中我们怎么办。很容易我们就想到了一个方式：可以构造一个User类来封装这两个属性。
 * 但是如果返回的两个值并没有任何关联关系，或者说每一个方法返回的参数都不同，那么我们就得为每一个方法的返回类型去创建对应的类来取包装，或许还有其他的解决方式，比如说返回一个map，返回一个List，返回一个array都可以。
 * 使用map作为返回值的话调用方在不清楚map中具体有什么内容的时候需要去遍历keySet或entrySet,而list和array也是同样的问题，不知道哪一个参数存放在哪里。
 *
 * 如果你经常使用apache的commons-lang3包来处理String的null判断，那么你依旧可以从这个包中找到我们想要的一个所谓的元组。
 */
public class CommonPairTest {


    //二元组
    @Test
    public void PairTest(){
        Pair<Integer, String> pair = Pair.of(1,"a");
        System.out.println(pair.getLeft());
        System.out.println(pair.getRight());
    }

    //三元组
    @Test
    public void TripleTest(){
        Triple<String, Integer, Double> uTriple = Triple.of("a",1,3d);
        System.out.println(uTriple.getLeft() + " -> " + uTriple.getMiddle() + ": " + uTriple.getRight());
    }
}
