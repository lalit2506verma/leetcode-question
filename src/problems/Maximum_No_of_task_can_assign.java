package problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Maximum_No_of_task_can_assign {
    public static void main(String[] args) {

    }

    public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n  = tasks.length;
        int m = workers.length;

        //  task -> ascending
        Arrays.sort(tasks);

        // workers -> ascending
        Arrays.sort(workers);

        int res = 0;
        int low = 0;
        int high = Math.min(m, n);

        while(low < high){
            int mid = low + (high - low) / 2;

            if(isPossible(tasks, workers, pills, strength, mid)){
                res = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return res;
    }

    private static boolean isPossible(int[] tasks, int[] workers, int pills, int strength, int mid) {
         int pillsUsed = 0;

         // UN-COMPLETE SOLUTION

         return true;
    }
}
