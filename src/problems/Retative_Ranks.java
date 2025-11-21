package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Retative_Ranks {
    public static void main(String[] args) {

    }

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0])); // score, originalIdx

        for(int i =0; i < n; i++){
            pq.offer(new int[]{score[i], i});
        }

        String[] ans = new String[n];
        int place = 1;
        while(!pq.isEmpty()){
            int[] arr = pq.poll();

            if(place == 1){
                ans[arr[1]] = "Gold Medal";
            }
            else if(place == 2){
                ans[arr[1]] = "Silver Medal";
            }
            else if(place == 3){
                ans[arr[1]] = "Bronze Medal";
            }
            else{
                ans[arr[1]] = String.valueOf(place);
            }
            place++;
        }

        return ans;
    }
}
