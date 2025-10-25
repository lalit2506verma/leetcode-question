package problems;

import java.util.Arrays;
import java.util.List;

public class Adjacent_Increasing_Subarrays_Detection_I {
    public static void main(String[] args) {
        Integer[] nums = {5,8,-2,-1};
        System.out.println(hasIncreasingSubarrays(Arrays.asList(nums), 2));
    }

    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        // base case
        if(n < 2*k){
            return false;
        }

        int i = 0;
        int j = 2*k;

        while(j <= n){
            if(isIncre(nums, i, i+k) && isIncre(nums, j-k, j)){
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

    public static boolean isIncre(List<Integer> nums, int st, int e){
        for(int i = st+1; i < e; i++){
            if(nums.get(i-1) >= nums.get(i)){
                return false;
            }
        }

        return true;
    }

}
