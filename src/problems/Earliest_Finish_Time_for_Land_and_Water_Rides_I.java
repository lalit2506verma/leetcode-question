package problems;

public class Earliest_Finish_Time_for_Land_and_Water_Rides_I {
    public static void main(String[] args) {
        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};

        System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // INTUTION
        // for every pair I need to find the time to complete it
        int minTime = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        for(int i = 0; i < n; i++){
            int landStart = landStartTime[i];
            int duration = landStart + landDuration[i];

            for(int j = 0; j < m; j++){
                int waterStart = waterStartTime[j];

                if(waterStart <= duration){
                    duration += waterDuration[j];
                }
                else{
                    int waitTime = waterStart - duration;
                    duration += (waitTime + waterDuration[j]);
                }

                minTime = Math.min(minTime, duration);
            }
        }

        return minTime;
    }
}
