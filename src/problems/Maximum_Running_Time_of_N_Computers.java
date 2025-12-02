package problems;

import java.util.Arrays;

public class Maximum_Running_Time_of_N_Computers {
    public static void main(String[] args) {
        int[] arr = {3,3,3};
        System.out.println(maxRunTime(2, arr));
    }

    public static long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        long low = Long.MAX_VALUE;

        for (int min : batteries){
            sum += min;
            low = Math.min(low, min);
        }

        long res = low;
        long high = sum / n;

        while(low <= high){
            long mid = low + (high - low) / 2;

            if(isPossible(n, batteries , mid)){
                res = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return res;
    }

    private static boolean isPossible(int n, int[] batteries, long mid) {
        long requiredTime = mid * n;

        long totalTime = 0;

        for(int num : batteries){
            totalTime += Math.min(mid, num);
        }

        if(totalTime >= requiredTime){
            return true;
        }
        return false;

    }
}
