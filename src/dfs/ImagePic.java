package dfs;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by chunchen.meng on 2019/7/15.
 */
public class ImagePic {


    public static void main(String[] args) {
        Map<String,List<String>> imageMap = new HashMap<>();
        List<String> image1 = new ArrayList<String>(){{add("pic1");add("pic2");add("pic3");}};
        List<String> image2 = new ArrayList<String>(){{add("pic4");add("pic2");add("pic6");}};
        List<String> image3 = new ArrayList<String>(){{add("pic7");add("pic8");}};

        imageMap.put("image1",image1);
        imageMap.put("image2",image2);
        imageMap.put("image3",image3);

        int needNum = 100;
        int dataLackType = 1;

        List<String> imageList = new ArrayList<>();
        ImagePic imagePic = new ImagePic();

        List<List<String>> tempList = new ArrayList<>(imageMap.values());
        imagePic.comb(imageMap,tempList,0,imageList,needNum,dataLackType);

    }
    List<List<String>> listResult = new ArrayList<>();


    private  void comb(Map<String,List<String>> map,List<List<String>> tempList,int index,List<String> imageList,int needNum,int dataLackType){
        //需要生成的组合数量
        if(needNum == listResult.size()){
            return;
        }

        //dataLackType = 1 元素不足可以使用
        if (index == map.size() && imageList.size() != map.size() && dataLackType == 1) {
            listResult.add(new ArrayList<String>(imageList));
            return;
        }

        if (imageList.size() == map.size() && !listResult.contains(imageList)) {
            listResult.add(new ArrayList<String>(imageList));
            imageList.stream().forEach(p -> System.out.print(" " + p));
            System.out.println();
            return;
        }


        for (; index < map.size(); index++) {

            for (int i = 0; i < tempList.get(index).size(); i++) {

                if (imageList.contains(tempList.get(index).get(i))) {
                    //有重复，跳出当前元素
                    continue;
                } else {
                    //无重复
                    imageList.add(tempList.get(index).get(i));
                    comb(map, tempList, index + 1, imageList, needNum,dataLackType);
                    imageList.remove(imageList.size() - 1);

                }
            }

        }


    }

    public static void combTest(Map<String, List<Integer>> map,
                                List<Integer> integerList,
                                List<Integer> tempList,
                                List<List<Integer>> resultList,
                                int needNum) {
        if(resultList.size() >= needNum) {
            return;
        }
        List<List<Integer>> listList = new ArrayList<>(map.values());
        for (int index = 0; index < listList.size(); index++) {
            if (integerList == listList.get(index)) {
                for (Integer integer : integerList) {
                    if (tempList.contains(integer)) {
                        continue;
                    }
                    List<Integer> res = Lists.newArrayList(tempList);
                    res.add(integer);
                    if (index < listList.size() - 1) {
                        combTest(map, listList.get(index + 1), res, resultList,needNum);
                    } else if (index == listList.size() - 1) {
                        resultList.add(res);
                    }
                }
            }
        }
    }

    public static void combTest2(Map<String, List<Integer>> map,
                                 List<Integer> integerList,
                                 List<Integer> tempList,
                                 List<List<Integer>> resultList) {
        List<List<Integer>> listList = new ArrayList<>(map.values());
        for (int index = 0; index < listList.size(); index++) {
            if (integerList == listList.get(index)) {
                for (Integer integer : integerList) {
                    List<Integer> res = Lists.newArrayList(tempList);
                    res.add(integer);
                    if (index < listList.size() - 1) {
                        combTest2(map, listList.get(index + 1), res, resultList);
                    } else if (index == listList.size() - 1) {
                        List<Integer> distinct = res.stream().distinct().collect(Collectors.toList());
                        if (distinct.size() < res.size()) {
                            continue;
                        }
                        resultList.add(res);
                    }
                }
            }
        }
    }
}
