//package guava;
//
//import com.google.common.base.Function;
//import com.google.common.collect.Lists;
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by chunchen.meng on 2018/6/1.
// */
//public class Partion {
//
//    public static void main(String[] args) throws Exception {
//
//        List<Long> list = new ArrayList<>();
//        list.add(1L);
//        list.add(2L);
//        list.add(3L);
//        list.add(4L);
//        list.add(5L);
//        list.add(6L);
//        list.add(7L);
//        list.add(8L);
//        list.add(9L);
//        list.add(10L);
//
//        List<List<Long>> originalPageList = Lists.partition(list, 3);
//        List<String> pageList = Lists.transform(originalPageList, new Function<List<Long>, String>() {
//            @Override
//            public String apply(List<Long> list) {
//                final StringBuffer pageSkuIds = new StringBuffer();
//                for(Long info : list) {
//                    pageSkuIds.append("AA_").append(info).append(",");
//                }
//                return pageSkuIds.toString();
//            }
//        });
//        System.out.println(pageList.toString());
//
//        Example example2 = new Example(1,"s");
//
//
//        Example example = Example.builder().bar("str").foo(1).build();
//        System.out.println(example.getBar());
//
//
//
//
//
////     InnerClass innerClass =  InnerClass.builder().bar("in").foo(23).build();
////     System.out.println(innerClass.getBar());
//
//
//        Partion partion = new Partion();
//
//        InnerClass innerClass = partion.new InnerClass();
//        innerClass.setBar("1212");
//
//        System.out.println(innerClass.getBar());
//    }
//
////    @Builder
//    @Data
//    public   class InnerClass {
//        private int foo;
//        private String bar;
//    }
//}
