import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by danny on 16/2/19.
 */
public class shopCSV {
    public  static  void  main(String[] args) {
        List<String> sqlData = new ArrayList<>();
        List<String> shopIds = new ArrayList<>();

        try {
            File csv = new File("/Users/danny/Downloads/test.csv");
            BufferedReader br = new BufferedReader(new FileReader(csv));

            String line = "";
            String itemUpdate ="";
            while ((line = br.readLine()) != null) {
//                String item[] = line.split(",");
                String item[] = line.split("\t");

                        itemUpdate =
                        "update DPPresales.PS_LeadShop  set CityId = "+item[1]+" , DistrictId = "+item[2]+" , ShopTypeId = "+item[3]+" where ShopId = "+item[0]+";\t";

                        System.out.println(itemUpdate);
                        sqlData.add(itemUpdate);
            }

            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
                fw = new FileWriter("/Users/danny/Downloads/Result.txt", true);
                bw = new BufferedWriter(fw, 100);
                for (String string:sqlData){
                    bw.write(string);

                }
            }catch (IOException e){

                System.out.println("写入文件出错");
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
