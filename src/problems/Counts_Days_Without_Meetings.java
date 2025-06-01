package problems;

import java.util.Arrays;
import java.util.Comparator;

public class Counts_Days_Without_Meetings {
    public static void main(String[] args) {
        int[][] meetings = {{1,2},{4,7},{3,8},{10,15}};
        System.out.println(countDays(15, meetings));
    }

    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int daysOff = 0;

        int end = 0;
        for (int[] meeting : meetings) {
            int start = meeting[0];
            if (start > end) {
                daysOff += (start - end - 1);
            }
            end = Math.max(end, meeting[1]);
        }

        if(end < days){
            daysOff += (days-end);
        }

        return daysOff;
    }
}
