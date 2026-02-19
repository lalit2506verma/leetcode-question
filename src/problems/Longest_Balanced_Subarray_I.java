package problems;

import java.util.HashSet;
import java.util.Set;

public class Longest_Balanced_Subarray_I {
    public static void main(String[] args) {
        int[] nums = {3,2,2,5,4};
        System.out.println(longestBalanced(nums));
    }

    public static int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            int e = 0;
            int o = 0;

            for(int j = i; j < n; j++){
                if(nums[j] % 2 == 0 && !even.contains(nums[j])){
                    e++;
                    even.add(nums[j]);
                }

                if(nums[j] % 2 != 0 && !odd.contains(nums[j])){
                    o++;
                    odd.add(nums[j]);
                }

                if(o == e){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }

        return maxLen;
    }
}
