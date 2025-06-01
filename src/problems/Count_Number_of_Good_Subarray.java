package problems;

import java.util.HashMap;

public class Count_Number_of_Good_Subarray {
    public static void main(String[] args) {
        int[] nums = {3,1,4,3,2,2,4};
        System.out.println(countGood2(nums, 2));
    }
    public static long countGood2(int[] nums, int k) {
        int n = nums.length;
        long pairs = 0;
        long ans = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int right = 0;

        while(right < n){
            //add
            pairs += freq.getOrDefault(nums[right], 0);
            freq.put(nums[right], freq.getOrDefault(nums[right], 0)+1);

            // shrink
            while(pairs >= k){
                ans += (n - right);
                freq.put(nums[left], freq.get(nums[left]) - 1);

                pairs -= freq.get(nums[left]);
                left++;
            }
            right++;
        }
        return ans;
    }

}
