package problems;

public class Search_In_Rotated_Sorted_Array_1 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        int idx = pivotIndex(nums);

        if(idx == -1){
            return binarySearch(nums, target, 0, nums.length-1);
        }
        else if(nums[idx] == target){
            return idx;
        }
        else if(nums[0] <= target){
            return binarySearch(nums, target, 0, idx-1);  // idx - 1 beacuse we have already check nums[idx] == target
        }
        else{
            return binarySearch(nums, target, idx+1, nums.length-1);
        }

    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int pivotIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/ 2;

            if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid-1]){
                return mid;
            }
            else if(nums[mid] > nums[low]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }
}
