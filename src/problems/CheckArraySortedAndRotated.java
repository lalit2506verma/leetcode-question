package problems;

public class CheckArraySortedAndRotated {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        int count = 0;
        for(int i = 0; i< nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                count++;
            }
        }

        if(count == 0){
            return true;
        }

        if(count != 1){
            return false;
        }


        if(nums[0] > nums[nums.length -1]){
            return true;
        }
        return false;
    }
}
