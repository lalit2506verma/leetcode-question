package problems;

import java.util.Arrays;

public class Minimum_the_Maximum_Difference_of_Pairs {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,1,3};
        System.out.println(minimizeMax(arr, 2));
    }

    public static int minimizeMax(int[] nums, int p) {
        // Sort the array
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        int l = 0;
        int r = nums[n-1] - nums[0]; // maximum diff

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(isPossible(nums, mid, p)){
                ans = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] nums, int mid, int p) {
        int count = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(Math.abs(nums[i] - nums[i+1]) <= mid){
                count++;
                i++;
            }

            if(count >= p){
                return true;
            }
        }

        return false;
    }
}
