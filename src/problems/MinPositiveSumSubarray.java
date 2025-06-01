package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinPositiveSumSubarray {
    public static void main(String[] args) {
       int[] nums = {3, -2, 1, 4};
       List<Integer> list = new ArrayList<>();
       for(int i : nums){
           list.add(i);
       }
        System.out.println(minimumSumSubarray(list, 2, 3));

    }

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++){
            int sum = 0;
            for(int j = 0; j <= j + i - 1 &&  j < nums.size()- i; j++){
                sum += nums.get(j);
            }

            minSum = Math.min(minSum, sum);
        }

        return minSum;
    }
}
