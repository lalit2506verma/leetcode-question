package problems;

import java.util.Arrays;

public class House_Robber_4 {
    static int n;
    public static void main(String[] args) {
        int[] nums = {2,3,5,9};
        System.out.println(minCapability2(nums, 2));
    }

    public static int minCapability(int[] nums, int k) {
        n = nums.length;
        return solve(nums, k, 0);
    }

    // recursive Approach
    public static int solve(int[] nums, int k, int idx){
        if(k == 0){
            return 0; // no more house to be robbed
        }
        if(idx >= n){
            return Integer.MAX_VALUE;
        }
        // rob the house on idx i
        int take = Math.max(nums[idx], solve(nums, k-1, idx+2));
        int skip = solve(nums, k, idx+1);

        return Math.min(take, skip);
    }

    public static int minCapability2(int[] nums, int k){
        int res = 0;

        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(nums, mid, k)){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }

    private static boolean isPossible(int[] nums, int mid, int k) {
        int houseCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= mid){
                houseCount++;
                i++;
            }
        }

        return houseCount >= k;
    }
}
