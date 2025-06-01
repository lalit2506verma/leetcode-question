package problems;

import java.util.Arrays;

public class PowerOfKSizeSubarrays {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4,2};
        int[] res = resultsArray(nums, 4);

        System.out.println(Arrays.toString(res));
    }

    public static int[] resultsArray(int[] nums, int k) {
        if(nums.length == 1){
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length - k + 1; i++){
            int temp = -1;
            for(int j = i; j < i + k - 1; j++){
                if(nums[j]+1 != nums[j+1]){
                    temp = -1;
                    break;
                }
                else{
                    temp = nums[j+1];
                }
            }

            res[i]=temp;
        }

        return res;
    }
}
