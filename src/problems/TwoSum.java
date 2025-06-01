package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++){
            // If HashMap is Empty
            if(map.isEmpty()){
                map.put(nums[i], i);
                continue;
            }
            map.put(nums[i], i);
            int rem = target - nums[i];

            if(map.containsKey(rem)){
                res[0] = i;
                res[1] = map.get(rem);
                break;
            }

            
        }

        return res;
    }
}
