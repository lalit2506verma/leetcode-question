package problems;

import java.util.HashMap;

public class Count_Elements_With_Maximum_Frequency {

    public static void main(String[] args) {

    }

    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        int count = 0;

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            int numFreq = freq.get(num);

            if(numFreq == maxFreq){
                count++;
            }

            // check if updated freq is more than maxFreq
            if(numFreq > maxFreq){
                maxFreq = numFreq;
                count = 1;
            }
        }

        return maxFreq * count;
    }
}
