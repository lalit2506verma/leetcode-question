package problems;

import java.util.Arrays;
import java.util.HashSet;

public class Maximum_Number_of_Distinct_Elements_After_Operations {
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 4};
        System.out.println(maxDistinctElements(nums, 1));
    }

    public static int maxDistinctElements(int[] nums, int k) {

        // sorting the array
        Arrays.sort(nums);

        int minElem = nums[0] - k;
        HashSet<Integer> set = new HashSet<>();
        set.add(minElem);

        for(int i = 1; i < nums.length; i++){
            int diff = Math.abs(minElem) - nums[i];

            if(diff >= -k && diff <= k){
                set.add(++minElem);
            }
        }

        return set.size();

    }
}
