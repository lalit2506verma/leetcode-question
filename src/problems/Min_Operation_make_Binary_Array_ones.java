package problems;

public class Min_Operation_make_Binary_Array_ones {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,0};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            if(nums[i] == 0){
                flip(nums, i);
                flip(nums, i+1);
                flip(nums, i+2);
                res++;
            }

        }

        if(nums[n-1] == 1 && nums[n-2] == 1){
            return res;
        }
        else{
            return -1;
        }
    }

    private static void flip(int[] nums, int i) {
        if(nums[i] == 1){
            nums[i] = 0;
        }
        else{
            nums[i] = 1;
        }
    }
}
