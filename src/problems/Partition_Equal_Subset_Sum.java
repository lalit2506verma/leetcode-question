package problems;

public class Partition_Equal_Subset_Sum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
         return isPossible(nums, 0, 0, 0);

    }

    public static boolean isPossible(int[] nums, int sumA, int sumB, int idx){
        if(idx == nums.length){
            return sumA == sumB;
        }

        boolean x = isPossible(nums, sumA + nums[idx], sumB, idx+1);
        boolean y = isPossible(nums, sumA, sumB+nums[idx], idx+1);

        return x || y;
    }
}
