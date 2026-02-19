package problems;

import java.util.HashMap;
import java.util.HashSet;

public class First_Element_with_Unique_Frequency {
    public static void main(String[] args) {

    }

    public int firstUniqueFreq(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        // count freq
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for(int count  : freq.values()){
            freqCount.put(count, freqCount.getOrDefault(count, 0) + 1);
        }

        HashSet<Integer> unique = new HashSet<>();
        for(int num : nums){
            if(!unique.contains(num)){
                unique.add(num);

                int frequency = freq.get(num);
                if(freqCount.get(frequency) == 1){
                    return num;
                }
            }
        }

        return -1;
    }
}
