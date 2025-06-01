package problems;

import java.util.Arrays;

public class Find_the_Smallest_Divisor_Threshold {

    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        System.out.println( smallestDivisor(nums, 5));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int ans = 0;
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(getSumDivisor(nums, mid) <= threshold){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int getSumDivisor(int[] nums, int mid) {
        int sum = 0;
        for (int num : nums){
            sum += Math.ceilDiv(num, mid);
        }
        return sum;
    }
}
