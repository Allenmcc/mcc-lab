/**
 * Created by danny on 2016/10/29.
 */
public class HeapSort {

    public static void adjust(int i,int len,int nums[]){

        int left = i*2+1;
        int right = i*2+2;
        int p =i;
        if(left<=len&&nums[left]>nums[p])
            p =left;
        if(right<=len&&nums[right]>nums[p])
            p = right;

        if(p!=i){
            int tmp = nums[p];
            nums[p] = nums[i];
            nums[i] = tmp;
            adjust(i,len,nums);

        }

    }

    public static void main(String args[]){
        int nums[] = {87,45,78,32,17,65,53,9,122};
        int len = nums.length - 1;
        for(int i=nums.length/2-1;i>=0;i--){
            adjust(i,len,nums);

        }

        for (int j= len;j>0;j--){
            int tmp = nums[0];
            nums[0] = nums[j];
            nums[j] = tmp;
            len--;
            adjust(0,len,nums);

        }
        for(int num:nums){
            System.out.print(num+" ");
        }

    }
}
