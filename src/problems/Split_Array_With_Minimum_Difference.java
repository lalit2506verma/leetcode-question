package problems;

public class Split_Array_With_Minimum_Difference {
    public static void main(String[] args) {
        int[] nums = {5,1,9,8};
        System.out.println(splitArray(nums));
    }

    public static long splitArray(int[] nums) {

        if(nums.length == 2){
            return Math.abs(nums[0] - nums[1]);
        }
        // find the peek
        boolean peekFound = false;
        int peekIdx = -1;
        int n = nums.length;
        for(int i = 1; i < n -1; i++){
            if(nums[i-1] < nums[i] && nums[i+1] < nums[i]){
                // peek found
                if(peekFound){
                    // more than 1 peek so not valid spilt
                    return -1;
                }
                peekFound = true;
                peekIdx = i;
            }

        }

        if(!peekFound){
            return -1;
        }
        long leftSum = nums[0];
        for(int i = 1; i < peekIdx; i++){
            if(nums[i] <= nums[i-1]) return -1;
            leftSum += nums[i];
        }

        long rightSum = 0;
        for(int i = peekIdx + 1; i < n; i++){
            if(nums[i] >= nums[i-1]) return -1;
            rightSum += nums[i];
        }

        long diff1 = Math.abs((leftSum + nums[peekIdx]) - rightSum);
        long diff2 = Math.abs(leftSum - (rightSum + nums[peekIdx]));

        return Math.min(diff1, diff2);
    }

//    private static long findSum(int[] nums, int s, int e) {
//        long sum = 0;
//        for(int i = s; i <= e; i++){
//            sum += nums[i];
//        }
//
//        return sum;
//    }
}
