package problems;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotate(nums, 3)));
    }

    public static int[] rotate(int[] nums, int k) {
        k = k % nums.length;

        if(k == 0){
            return nums;
        }
        int[] tempArr = new int[k];
        int j = 0;
        for(int i = nums.length - k; i < nums.length; i++){
            tempArr[j++] = nums[i];
        }

        for(int i = 0; i < nums.length - k; i++){
            nums[i+k] = nums[i];
        }

        for(int i = 0; i < tempArr.length; i++){
            nums[i] = tempArr[i];
        }

        return nums;
    }
}
