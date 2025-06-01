package problems;

import java.util.Arrays;

public class First_and_Last_Occurance_In_SortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        res[0] = firstOccurance(nums, target);
        res[1] = lastOccurance(nums, target);

        return res;
    }

    private static int lastOccurance(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                ans = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }

    private static int firstOccurance(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                ans = mid;
                high = mid - 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
