package problems;

public class Minimum_Operations_to_Make_Array_Equal_to_Target {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        int[] target = {2,1,4};
        System.out.println(minimumOperations(nums, target));
    }

    public static long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;

        int[] diff = new int[n];

        for(int i = 0; i < n; i++){
            diff[i] = target[i] - nums[i];
        }

        long minOperations = 0;
        int prev = 0;
        for(int i = 0; i < n; i++){
            int curr = diff[i];

            // Sign change
            if(curr > 0 &&  prev < 0 || curr < 0 && prev > 0){
                minOperations += Math.abs(curr);
                prev = curr;
                continue;
            }

            if(Math.abs(curr) > Math.abs(prev)){
                minOperations += (Math.abs(curr) - Math.abs(prev));
            }

            prev = curr;
        }

        return minOperations;
    }
}
