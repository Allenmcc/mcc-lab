import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by danny on 16/8/2.
 */
public class Main {


    public static void recursionSub(LinkedList<String[]> list, int count, String[] array, int ind, int start,
                                    int... indexs)
    {
        start++;
        if(start > count - 1)
        {
            return;
        }
        if(start == 0)
        {
            indexs = new int[array.length];
        }
        for(indexs[start] = ind; indexs[start] < array.length; indexs[start]++)
        {
            recursionSub(list, count, array, indexs[start] + 1, start, indexs);
            if(start == count - 1)
            {
                String[] temp = new String[count];
                for(int i = count - 1; i >= 0; i--)
                {
                    temp[start - i] = array[indexs[start - i]];
                }
                list.add(temp);
            }
        }
    }

    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case

            String string = null;
            String string2 = null;
            string = in.nextLine();
            string2 = in.nextLine();
            String[] A = string.split("(?!\\b)");
            LinkedList<String[]> list = new LinkedList<String[]>();
            int flag = 0;
            label:
            for (int i = 1; i <= A.length; i++) {
                recursionSub(list, i, A, 0, -1);
                for (String[] strings : list) {
                    if (Arrays.toString(strings).replaceAll("[\\[\\],\\s]", "").contains(string2)) {
                        System.out.println("Yes");
                        break label;
                    }
                }
                list.clear();
                if (i == A.length - 1) {
                    flag = 1;
                }
            }
            if (flag == 1) {
                System.out.println("No");
            }
        }


    }
}
