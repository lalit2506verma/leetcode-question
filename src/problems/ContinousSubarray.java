package problems;

public class ContinousSubarray {
    public static void main(String[] args) {
        int[] nums = {5,4,2,4};
        System.out.println(continuousSubarrays(nums));
    }

    public static long continuousSubarrays(int[] nums) {
        long count = 0;

        // sliding window
        for(int i = 0; i < nums.length; i++){
            int max = nums[i];
            int min = nums[i];
            for(int j = i; j < nums.length; j++){

                

            }
        }

        return count;
    }
}
