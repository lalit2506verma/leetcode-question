package problems;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> res = fourSum(nums, target);

        for (List<Integer> re : res) {
            System.out.print("[ ");
            for (Integer integer : re) {
                System.out.print(integer + ", ");
            }
            System.out.print("]");
        }
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){

            for(int j = i+1; j < nums.length; j++){

                int l = j+1;
                int r = nums.length -1;
                while(l < r){
                    long total = (long)nums[i] + nums[j] + nums[l] + nums[r];

                    if(total == target){
                        s.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    }
                    else if(total > target){
                        r--;
                    }
                    else{
                        l++;
                    }
                }
            }
        }

        res.addAll(s);
        return res;
    }
}
