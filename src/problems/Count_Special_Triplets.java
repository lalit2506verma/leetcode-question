package problems;

import java.util.HashMap;

public class Count_Special_Triplets {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        int[] nums = {8,8,4,4,2,8,4,4,8};
        System.out.println(specialTriplets(nums));
    }

    public static int specialTriplets(int[] nums) {
        HashMap<Integer, Integer> validJ = new HashMap<>();
        HashMap<Integer, Integer> validI = new HashMap<>();
        long count = 0;

        for(int num : nums) {
            // check valid k
            if(validJ.containsKey(num / 2)){
                count = (count + validJ.get(num / 2) % MOD);
            }

            // Valid j
            if(validI.containsKey(num * 2)) {
                validJ.put(num, (validI.get(num * 2) + validJ.getOrDefault(num, 0) % MOD));
            }

            validI.put(num, validI.getOrDefault(num, 0) + 1);
        }

        return (int)count;
    }
}
