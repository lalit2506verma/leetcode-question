package problems;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int idx){
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = n-2; i >=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        // Edge case;
        if(idx == -1){
            Arrays.sort(nums);
            return;
        }

        for(int i = n-1; i >= 0; i--){
            if(nums[i] > nums[idx]){
                swap(nums, i, idx);
                break;
            }
        }

        // reversing all the element after break point
        Arrays.sort(nums, idx+1, n);
    }
}
