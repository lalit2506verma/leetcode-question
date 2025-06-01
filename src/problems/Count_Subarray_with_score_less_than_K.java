package problems;

public class Count_Subarray_with_score_less_than_K {
    public static void main(String[] args) {
        int[] arr = {2,1,4,3,5};
        System.out.println(countSubarrays(arr, 10));
    }

    public static long countSubarrays(int[] nums, long k) {
        int i = 0;
        int j = 0;
        long count = 0;
        long sum = 0;
        while(j < nums.length){
            // add
            sum += nums[j];

            while((sum * (j - i + 1)) >= k){
                sum -= nums[i];
                i++;
            }

            count += (j-i + 1);
            j++;
        }

        return count;
    }
}
