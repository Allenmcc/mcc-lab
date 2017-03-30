/**
 * Created by danny on 16/9/18.
 */

import java.util.Scanner;
import java.util.*;

public class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = fun(n);
        System.out.println(num);
    }

    public  static int fun(int n)
    {
        int num = 0;

        while(n!=0)
        {
            num += n / 5;
            n = n / 5;
        }

        return num;
    }

}
