package problems;

import java.util.Arrays;
import java.util.Comparator;

public class FindScoreForArray {
    public static void main(String[] args) {
        int[] nums = {2,1,3,4,5,2};
        System.out.println(findScore(nums));
    }

    public static long findScore(int[] nums) {
        int n = nums.length;
        int[][] scores = new int[n][2];
        boolean[] visited = new boolean[n];
        long score = 0;
        // Assinging value in the 2D array
        for(int i = 0; i < nums.length; i++){
            scores[i][0] = nums[i];
            scores[i][1] = i;
        }

        //Sort the array
        Arrays.sort(scores, Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < scores.length; i++){
            // if the score is marked
            if(visited[scores[i][1]]){
                continue;
            }

            // adding in the score
            long smallest = scores[i][0];
            int currIdx = scores[i][1];

            score += smallest;

            //marking visited
            if(currIdx - 1 >= 0){
                visited[currIdx-1] = true;
            }

            if(currIdx + 1 < n){
                visited[currIdx +1] = true;
            }

            visited[currIdx] = true;
        }

        return score;
    }
}

