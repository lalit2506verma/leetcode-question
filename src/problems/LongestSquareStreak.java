package problems;

import java.util.*;

public class LongestSquareStreak {
    public static void main(String[] args) {
        int[] nums = {4,3,6,16,8,2};
        System.out.println(longestSquareStreak(nums));
    }


    public static int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = -1;

        for(int num:nums){
            set.add(num);
        }

        List<Integer> setArr = new ArrayList<>(set);
        Collections.sort(setArr);

        for(int i = 0; i < setArr.size(); i++){
            int curr = setArr.get(i);
            int temp = 0;

            while(set.contains(curr)){
                set.remove(curr);
                curr = curr * curr;
                count++;
            }

            count = Math.max(count, temp);
        }

        return count > 1 ? count:-1;
    }
}
