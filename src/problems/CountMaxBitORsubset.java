package problems;

public class CountMaxBitORsubset {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5};

        int res = countMaxOrSubsets(nums);
        System.out.println(res);
    }

    public static void backtrack(int[] nums, int idx, int currOR, int maxOR, int[] count){
        if(currOR == maxOR){
            count[0]++;
        }

        for(int i = idx; i < nums.length; i++){
            backtrack(nums, i+1, currOR | nums[i], maxOR, count);
        }
    }
    public static int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        int[] count  = new int[1];
        for(int i = 0; i < nums.length; i++){
            maxOR |=  nums[i];
        }

        // Now we have max OR of the set

        //Backtracking to calculate OR of all the subset of the given set\
        backtrack(nums, 0, 0, maxOR, count);

        return count[0];
    }
}
