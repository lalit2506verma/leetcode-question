package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    static HashSet<Integer> set = new HashSet<>();
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> res = permute(nums);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static void helper(int[] nums, List<Integer> list){
        if(list.size() == nums.length){
            result.add(list);
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                // take
                set.add(nums[i]);
                list.addLast(nums[i]);

                helper(nums, list);

                // backtracking
                list.removeLast();
                set.remove(nums[i]);
            }

        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();

        helper(nums, list);

        return result;
    }
}
