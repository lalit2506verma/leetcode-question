package problems;

import java.util.Arrays;

public class Count_the_Number_of_Fair_Pair {
    public static void main(String[] args) {
        int[] nums = {1,7,9,2,5};
        System.out.println(countFairPairs(nums, 11, 11));
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;

        for (int i = 0; i+1 < nums.length; i++) {

            int tempLowerIndex = lowerBound(nums, i+1, nums.length, lower-nums[i]);
            int tempUpperIndex = upperBound(nums, i+1, nums.length, upper-nums[i]);

            ans += (tempUpperIndex - tempLowerIndex);
        }

        return ans;
    }

    private static int lowerBound(int[] nums, int start, int end,  int i) {
        int left  = start;
        int right = end;
        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] < i){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    private static  int upperBound(int[] nums, int start, int end,  int i){
        int left = start;
        int right = end;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] <= i){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    // Two pointer approach
    public static long countFairPairs2(int[] nums, int lower, int upper){
        //sort
        Arrays.sort(nums);

        return countPair(nums, upper) - countPair(nums, lower);
    }

    private static long countPair(int[] nums, int target) {
        long ans = 0;
        int j = nums.length-1;

        // for every number int the array we need to find the pairs
        for (int i = 0; i < j; i++) {
            while( i < j && nums[i] + nums[j] > target){
                j--;
            }
            ans += (j-i);
        }
        return ans;
    }
}
