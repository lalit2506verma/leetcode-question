package problems;

import java.util.Arrays;

public class Capacity_to_Ship_Packages_D_Days {
    public static void main(String[] args) {
        int[] weights = {1,2,3,1,1};
        System.out.println(shipWithinDays(weights, 4));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int ans = 0;
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(countDays(weights, mid) <= days){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int countDays(int[] weights, int mid) {
        int days = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if(sum + weights[i] > mid){
                days++;
                sum = 0;
            }
            sum += weights[i];
        }
        return days;
    }
}
