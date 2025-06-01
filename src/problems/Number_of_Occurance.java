package problems;

public class Number_of_Occurance {
    public static void main(String[] args) {
        int[] nums = {10, 11};
        System.out.println(countOccurance(nums, 10));
    }

    public static int countOccurance(int[] nums, int target){
        int first = firstOccurance(nums, target);
        int last = lastOccurance(nums, target);

        if(first == -1 && last == -1){
            return 0;
        }
        return last - first + 1;
    }

    private static int lastOccurance(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                ans = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }

    private static int firstOccurance(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                ans = mid;
                high = mid - 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
