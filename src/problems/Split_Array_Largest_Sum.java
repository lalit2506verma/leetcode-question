package problems;

public class Split_Array_Largest_Sum {
    public static void main(String[] args) {
        int[] array = {2,3,1,2,4,3};
        System.out.println(splitArray(array, 5));
    }

    public static int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        //upper bound will be sum of the largest subarray -> array
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }

        if(k == nums.length){
            return low;
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(nums, mid, k)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] nums, int sum, int k){
        int split = 1;
        int subarraySum = 0;

        for(int i = 0; i < nums.length; i++){
            if(subarraySum + nums[i] > sum){
                split++;
                subarraySum = nums[i];
            }
            else{
                subarraySum += nums[i];
            }
        }

        if(split <= k){
            return true;
        }

        return false;
    }
}
