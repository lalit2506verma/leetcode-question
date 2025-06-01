package problems;

import java.util.Arrays;

public class Maximum_Candies_Allocation {
    public static void main(String[] args) {
        int[] candies = {5,8,6};
        int k = 3;
        System.out.println(maximumCandies(candies, k));
    }

    public static int maximumCandies(int[] candies, long k){
        // edge case -> K must me less than sum of candies
        long candiesSum = Arrays.stream(candies).sum();
        if(k > candiesSum){
            return 0;
        }

        // Binary Search on solution space
        int res = 0;
        Arrays.sort(candies);
        int low = 1;
        int high = candies[candies.length-1];

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPossible(mid, candies, k)){
                res = mid;
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }

        return res;
    }

    private static boolean isPossible(int mid, int[] candies, long k) {
        int count = 0;
        for(int c : candies){
            if(mid <= c){
                count += (c / mid);
            }

            if(count >= k){
                return true;
            }
        }
        return false;
    }
}
