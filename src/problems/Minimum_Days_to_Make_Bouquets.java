package problems;

import java.util.Arrays;

public class Minimum_Days_to_Make_Bouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        System.out.println(minDays(bloomDay, 3, 1));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int ans = -1;
        int n = bloomDay.length;
        // Impossible Case

        if(m * k > n){
            return -1;
        }

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPossible(bloomDay, m, k, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] bloomDay, int m, int k, int mid) {
        int flowerBloom = 0;
        int counter = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                counter++;
            }
            else{
                flowerBloom += (counter / k);
                counter = 0;
            }
        }

        flowerBloom += (counter / k);

        if(flowerBloom >= m){
            return true;
        }

        return false;
    }
}
