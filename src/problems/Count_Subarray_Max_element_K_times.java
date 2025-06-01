package problems;

public class Count_Subarray_Max_element_K_times {
    public static void main(String[] args) {
        int[] arr = {1,4,2,1};
        System.out.println(countSubarrays(arr, 3));
    }

    public static long countSubarrays(int[] nums, int k) {
        int i = 0, j = 0;
        long count = 0;
        int max = 0;
        for (int num: nums){
            max = Math.max(max, num);
        }
        int maxCount = 0;
        while(j < nums.length){
            // add
            if(nums[j] == max){
                maxCount++;
            }

            while(maxCount >= k){
                count += (nums.length - j);
                if(nums[i] == max){
                    maxCount--;
                }
                i++;
            }
            j++;
        }

        return count;
    }
}
