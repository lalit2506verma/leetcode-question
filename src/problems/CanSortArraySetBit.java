package problems;

public class CanSortArraySetBit {

    public static void main(String[] args) {
        int[] nums = {3,16,8,4,2};

        System.out.println(canSortArray(nums));
    }

    public static void swap(int[] nums, int j){
        int temp = nums[j];
        nums[j] = nums[j+1];
        nums[j+1] = temp;
    }

    public static int setBits(int n){
        int count = 0;
        while(n > 0){
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    public static boolean checkSetBits(int n1, int n2){
        if(setBits(n1) == setBits(n2)){
            return true;
        }
        return false;
    }
    public static boolean canSortArray(int[] nums) {
        boolean swapped;
        for(int i = 0; i < nums.length - 1; i++){
            swapped = false;
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    if(checkSetBits(nums[j], nums[j+1])){
                        swap(nums, j);
                        swapped = true;
                    }
                    else {
                        return false;
                    }
                }
            }

            if(!swapped){
                break;
            }
        }

        return true;
    }
}
