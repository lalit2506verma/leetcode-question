package problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Jump_Game_3 {
    public static void main(String[] args) {

    }

    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int currIdx = queue.poll();
            if(visited.contains(currIdx)){
                continue;
            }
            visited.add(currIdx);
            if(currIdx < 0 || currIdx >= arr.length){
                continue;
            }

            if(arr[currIdx] == 0){
                return true;
            }else{
                queue.add(currIdx + arr[currIdx]);
                queue.add(currIdx - arr[currIdx]);
            }
        }

        return false;
    }
}
