package problems;

import java.util.PriorityQueue;

public class Maximum_Average_Pass_Ratio {
    public static void main(String[] args) {

    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> deltaPQ = new PriorityQueue<>((a,b) -> Double.compare(b[1], a[1]));

        int n = classes.length;

        for(int i = 0; i < n; i++){
            double delta = findDelta(classes[i][0], classes[i][1]);

            deltaPQ.offer(new double[]{delta, i});
        }

        while(extraStudents-- > 0){
            // pick the largest delta from priority queue
            double[] curr = deltaPQ.poll();
            double delta = curr[0];
            int idx = (int) curr[1];

            // student added
            classes[idx][0]++;
            classes[idx][1]++;

            delta = findDelta(classes[idx][0], classes[idx][1]);

            deltaPQ.offer(new double[]{delta, idx});
        }

        // all student is assigned

        double totalPR = 0.0;

        for(int i = 0; i < n; i++){
            totalPR += ((double) classes[i][0] / classes[i][1]);
        }

        return totalPR / n;
    }

    private static double findDelta(int pass, int total){
        return ((double) pass / total - (pass + (double) 1 / total + (double) 1));
    }

}
