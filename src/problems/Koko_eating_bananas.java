package problems;

import java.util.Arrays;

public class Koko_eating_bananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        System.out.println(minEatingSpeed(piles, 6));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPossible(piles, h, mid) >= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    private static int isPossible(int[] piles, int h, int mid) {
        int hours = 0;
        for(int pile: piles){
            hours += (pile / mid);
        }
        return hours;
    }
}
