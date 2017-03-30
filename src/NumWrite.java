import java.io.*;

/**
 * Created by danny on 15/12/18.
 */
public class NumWrite {
    public static final int number = 1000000;


    public static void writeTxt(String path){
        File file=new File(path);

        try {
            if(!file.exists()) file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(long k=0;k<number;k++){
                long   l   =   (long)(Math.random()*number);
                String   s   =   ""+l;
                int   i   =   s.length();
                for(int   j=0;j <9-i;j++){
                    s   =   "0"+s;
                }
                System.out.println(s);
                writer.write(s);
                writer.newLine();
            }

            writer.flush();
            writer.close();

        } catch (Exception e1) {
// TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static int[] readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        int[] nums = new int[number + 1];
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                nums[line-1] = Integer.parseInt(tempString);
                line++;
            }
            reader.close();
            return nums;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return nums;
    }


    public static void main(String arg[]){
        String path = "/Users/danny/Downloads/num";
        readFileByLines(path);


    }
}
