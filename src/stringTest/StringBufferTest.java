package stringTest;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by danny on 2017/1/18.
 */
public class StringBufferTest {
    public static void main(String[] args) {

        List<ProductVO> products = Lists.newArrayList();
        ProductVO productVO = new ProductVO();
        productVO.setName("服务器");
        productVO.setId(1);
        ProductVO p2 = new ProductVO();
        p2.setName("抓拍机");
        p2.setId(2);
        products.add(productVO);
        products.add(p2);


        StringBuffer stringBuffer = new StringBuffer();
        products.forEach(p -> {
            Integer productId = p.getProductId();
//            if (null == p) {
                stringBuffer.append("【").append(p.getName()).append("】").append("已被删除，请更新产品信息").append("\n");
//                throw new CrmException("产品已删，请重新选择产品");
//            }
        });

        if (!StringUtils.isEmpty(stringBuffer.toString())) {
            System.out.println(stringBuffer.toString());
//            throw Error(stringBuffer.toString());
        }else{
            System.out.println("111");
        }



    }


    @Test
    public void generateBackNoWithPrefix() {
        StringBuffer shortBuffer = new StringBuffer();
        shortBuffer.append("R");
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 8; i++) {
            //首字母不能为0
            result += (random.nextInt(10));
        }
        shortBuffer.append(result);
        System.out.printf(shortBuffer.toString());
    }






}