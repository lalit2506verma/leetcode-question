package problems;

public class Longest_Nice_Subarray {
    public static void main(String[] args) {

    }

    public static int longestNiceSubarray(int[] nums) {
        int i = 0;
        int j = 0;

        int res = 1;
        int mask = 0;

        while(j < nums.length){
            // shrink
            while((mask & nums[j]) != 0){
                mask = mask ^ nums[i];
                i++;
            }

            // calculate
            res = Math.max(res, j-i+1);
            mask = mask | nums[j];
            j++;
        }

        return res;
    }
}
