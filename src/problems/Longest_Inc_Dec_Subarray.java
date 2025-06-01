package problems;

public class Longest_Inc_Dec_Subarray {
    public static void main(String[] args) {
        int[] arr = {21,32,1,39,40,24,6,21,24,33,25,33,6,50,34,14,24,12,2,1};

        System.out.println(longestMonotonicSubarray(arr));
    }

    public static int longestMonotonicSubarray(int[] nums) {
        int incLen = 1;
        int decLen = 1;
        int inc = 1;
        int dec = 1;
        // Strictly increasing
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] < nums[i+1]){
                inc++;
                continue;
            }

            incLen = Math.max(incLen, inc);
            inc = 1;
        }

        // Strictly decreasing
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                dec++;
                continue;
            }

            decLen = Math.max(decLen, dec);
            dec = 1;
        }

        // Check at last if whole array is strictly inc and dec
        incLen = Math.max(incLen, inc);
        decLen = Math.max(decLen, dec);

        return Math.max(decLen, incLen);
    }
}
