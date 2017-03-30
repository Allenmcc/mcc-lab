import java.util.Scanner;

/**
 * Created by danny on 16/4/6.
 */
public class T2 {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int[][] a = new int[line][4];
        for (int i = 0; i < line; i++) {
            int count = scanner.nextInt();
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
            a[i][2] = scanner.nextInt();
            a[i][3] = 0;
            for (int j = 0; j < count; j++) {
                a[i][3] += scanner.nextInt();
            }
        }

        for (int i = 0; i < line; i++) {
            float avgCountF = (float)a[i][3] / a[i][0];
            int avgCount = avgCountF == (int)avgCountF ? (int)avgCountF : (int)avgCountF + 1;
            int area = a[i][2] * a[i][1];
            float length =  (float) Math.sqrt(area / avgCount);
            int min = a[i][1] < a[i][2] ? a[i][1] : a[i][2];
            System.out.println(min > length ? (int)length : min);
        }
    }

}
