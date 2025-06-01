package problems;

import java.util.Arrays;
import java.util.List;

public class Minimum_Index_valid_split {
    public static void main(String[] args) {
        Integer[] arr = {3,3,3,3,7,2,2};
        List<Integer> nums = Arrays.asList(arr);
        System.out.println(minimumIndex(nums));
    }

    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int majority = majorityElement(nums);

        int[] freq = new int[n];
        if(nums.getFirst() == majority) freq[0] = 1;

        for(int i = 1; i < n; i++){
            if(nums.get(i) == majority){
                freq[i] = freq[i-1]+1;
            }
            else{
                freq[i] = freq[i-1];
            }
        }
        int count = freq[n-1];

        for (int i = 0; i < n; i++) {
            if(freq[i] > (i+1)/2 && (count - freq[i]) > (n - i - 1)/2){
                return i;
            }
        }

        return -1;
    }

    public static int majorityElement(List<Integer> nums){
        int count = 0;
        int candidate = 0;

        for (int num : nums){
            if(count == 0){
                candidate = num;
            }

            if(num == candidate){
                count++;
            }
            else{
                count--;
            }
        }
        return candidate;
    }
}
