package sort;

/**
 * Created by danny on 2016/10/31.
 * https://blog.csdn.net/nrsc272420199/article/details/82587933
 * 快速排序,说白了就是给基准数据找其正确索引位置的过程.
 */
public class QuickSort {


    public static void quickSort(int s[], int l, int r) {
//        if (l < r) {

        if(l >= r){
            System.out.println(l +":"+r);
            return;
        }
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x)
                    j--;
                if (i < j)
                    s[i++] = s[j];
                while (i < j && s[i] < x)
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
//        }
    }

    private static void quickSort2(int[] arr, int low, int high) {

//        if (low < high) {
        if (low >= high) {
            System.out.println(low +":"+high);
            //出口,基线条件
            return;
        }
        // 找寻基准数据的正确索引
        int index = getIndex(arr, low, high);

        // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
        quickSort2(arr, low, index - 1);
        quickSort2(arr, index + 1, high);
//        }
    }



    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }

    public static void main(String[] args) {
//        int []nums = {87, 45, 78, 32, 17, 65, 53, 9, 122};
        int []nums = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(nums,0,nums.length-1);
        for (int i:nums){
            System.out.print(i+ " ");
        }
    }
}
