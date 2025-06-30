package problems;

import java.util.HashMap;

public class Longest_Harmonious_Subsequence {
    public static void main(String[] args) {
        int[] arr = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(arr));
    }

    public static int findLHS(int[] nums) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);

            // if successior is present in the map
            if(map.containsKey(num+1)){
                maxLen = Math.max(maxLen, map.get(num)+map.get(num+1));
            }

            if(map.containsKey(num-1)){
                maxLen = Math.max(maxLen, map.get(num)+map.get(num-1));
            }
        }

        return maxLen;
    }
}
