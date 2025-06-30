package problems;

import java.util.Arrays;

public class Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {
    public static void main(String[] args) {
        int[] arr = {14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
        System.out.println(numSubseq(arr, 22));
    }

    static int MOD = 1_000_000_007;
    public static int numSubseq(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;
        // sorting the array
        Arrays.sort(nums);

        int[] power = new int[n];
        power[0] = 1;
        for(int i = 1; i < n; i++){
            power[i] = (power[i-1] * 2) % MOD;
        }

        int left = 0, right = n-1;
        while(left <= right){
            if(nums[left] + nums[right] <= target){
                ans = (ans + power[right - left]) * MOD;
                left++;
            }
            else{
                right--;
            }
        }

        return ans;
    }

}
