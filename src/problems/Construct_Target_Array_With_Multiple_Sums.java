package problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class Construct_Target_Array_With_Multiple_Sums {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2};
        System.out.println(isPossible(arr));
    }

    public static boolean isPossible(int[] target) {
        if(target.length == 1) return target[0] == 1;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : target){
            sum += num;
            pq.add(num);
        }

    while(pq.peek() != 1){
        int curr = pq.poll();
        if(sum - curr == 1) return true;

        int x = (sum - curr) % curr;
        sum = sum - curr + x;
        if(x == 0 || x == curr) return false;
        else pq.add(x);
    }
        return true;
    }
}
