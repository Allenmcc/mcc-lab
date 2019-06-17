package utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by danny on 15/10/27.
 */
public class CSVUtils {
public  static  void  main(String[] args) {
    List<String> sqlData = new ArrayList<>();
    List<String> shopIds = new ArrayList<>();

    try {
        File csv = new File("/Users/danny/Downloads/PapaParse-master/tests/test11.csv");
        BufferedReader br = new BufferedReader(new FileReader(csv));

        String line = "";
        String itemUpdate = "";
        String itemInsert ="";
        String tmpShops = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while ((line = br.readLine()) != null) {
            String item[] = line.split(",");

            switch ( item[1] ) {
                case "A":
                     shopIds.add(item[0]);
                     itemInsert = "insert into TPRotateShop.AdApolloShopRating" +
                            "(ShopId, Type, BizID, Rating, Status, CreatedBy ,LastModifiedBy ,CreatedTime) "
                            + "VALUES (" + item[0] + ",3,101,303,1,0,0,'"+df.format(new Date())+"');";
                    System.out.println(itemInsert);
                    sqlData.add(itemInsert);
                    break;
                case "KK":
                    shopIds.add(item[0]);
                    itemInsert = "insert into TPRotateShop.AdApolloShopRating" +
                            "(ShopId, Type, BizID, Rating, Status, CreatedBy ,LastModifiedBy ,CreatedTime) "
                            + "VALUES (" + item[0] + ",3,101,301,1,0,0,'"+df.format(new Date())+"');";
                    System.out.println(itemInsert);
                    sqlData.add(itemInsert);
                    break;
                case "K":
                    shopIds.add(item[0]);
                    itemInsert = "insert into TPRotateShop.AdApolloShopRating" +
                            "(ShopId, Type, BizID, Rating, Status, CreatedBy ,LastModifiedBy ,CreatedTime) "
                            + "VALUES (" + item[0] + ",3,101,302,1,0,0,'"+df.format(new Date())+"');";
                    System.out.println(itemInsert);
                    sqlData.add(itemInsert);
                    break;
                default:
                    System.out.println("数据异常");
            }


        }

        for(int i=0; i<shopIds.size();i++){
            tmpShops += shopIds.get(i)+",";
        }
        tmpShops = tmpShops.substring(0,tmpShops.length()-1);
        itemUpdate ="update TPRotateShop.AdApolloShopRating set status='0' where shopid in("+tmpShops+");";
        sqlData.add(0, itemUpdate);
//        System.out.println(sqlData.get(0));
//        System.out.println(sqlData);
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("/Users/danny/Downloads/PapaParse-master/tests/" +
                "Result.txt")));
        boolean flag = false;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("/Users/danny/Downloads/PapaParse-master/tests/Result.txt", true);
            bw = new BufferedWriter(fw, 100);
            for (String string:sqlData){
                bw.write(string);

            }
            flag = true;
        }catch (IOException e){

            System.out.println("写入文件出错");
            flag = false;
        }finally {
            if (bw != null){
                bw.flush();
                bw.close();
            }
            if (fw!=null)
                fw.close();
        }


        br.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
