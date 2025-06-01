package problems;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-time-to-repair-cars/?envType=daily-question&envId=2025-03-16
public class Minimum_time_to_repair {
    public static void main(String[] args) {
        int[] ranks = {4,2,3,1};
        System.out.println(repairCars(ranks, 10));
    }

    public static long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long low = 0; // minimum time possible
        long high = Arrays.stream(ranks).max().getAsInt() * cars * cars;

        long res = 0;
        while(low <= high){
            long mid = low + (high - low)/ 2;

            if(isPossible(ranks, cars, mid)){
                res = mid;
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }

        return res;
    }

    private static boolean isPossible(int[] ranks, int cars, long mid) {
        long repaired_cars = 0;
        for (int rank : ranks){
            repaired_cars += (long) Math.sqrt(mid / rank);
            if(repaired_cars >= cars) return true;
        }

        return false;

    }
}
