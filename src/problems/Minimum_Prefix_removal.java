package problems;

public class Minimum_Prefix_removal {
    public static void main(String[] args) {
        int[] nums = {1,-1,2,3,3,4,5};
        System.out.println(minimumPrefixLength(nums));
    }

    public static int minimumPrefixLength(int[] nums) {
        int n = nums.length;

        int count = -1;

        for(int i = n-2; i >= 0; i--){
            if(nums[i] >= nums[i+1]){
                count = i + 1;
            }
        }

        if(count == -1){
            return 0;
        }
        else{
            return count;
        }
    }
}
