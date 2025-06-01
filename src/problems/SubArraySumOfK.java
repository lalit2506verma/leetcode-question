package problems;

public class SubArraySumOfK {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1};
        System.out.println(subarraySum(nums, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        // Brute force approach
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[i];
                if(sum == k){
                    count++;
                }

                if(sum > k){
                    break;
                }
            }
        }

        return count;
    }
}
