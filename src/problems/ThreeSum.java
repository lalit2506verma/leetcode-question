package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> res = threeSum(nums);

        for (List<Integer> re : res) {
            System.out.print("[ ");
            for (Integer integer : re) {
                System.out.print(integer + ", ");
            }
            System.out.print("]");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            // fixing duplicates
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // fixing the first element
            int requiredSum = -nums[i];

            int l = i+1;
            int r = nums.length - 1;

            while(l < r){
                if(nums[l] + nums[r] == requiredSum){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
                else if(nums[l] + nums[r] > requiredSum){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            // fixing the first element
            int requiredSum = -nums[i];

            for (int j = 0; j < nums.length; j++) {
                int secondElement = nums[j];
            }

        }
        return res;
    }
}
