package problems;

public class Search_In_Rotated_Sorted_Array_2 {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        System.out.println(search(nums, 3));
    }

    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while(start <= end){
            int mid = start + (end -  start)/2;

            if (nums[mid] == target) {
                return true;
            }
            if(nums[mid] == nums[start] && nums[mid] == nums[end]){
                start = start + 1;
                end = end - 1;
                continue;
            }
            // if left part is sorted
            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else { // if right part is sorted
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }

        return false;
    }


}
