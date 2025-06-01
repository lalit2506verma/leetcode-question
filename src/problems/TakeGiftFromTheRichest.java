package problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftFromTheRichest {
    public static void main(String[] args) {
        int[] nums = {25,64,9,4,100};
        System.out.println(pickGifts(nums,4));
    }

    public static long pickGifts(int[] gifts, int k) {
        long res = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // adding all values in the maxHeap;
        for(int gift : gifts){
            maxHeap.add(gift);
        }

        for(int i = 1; i <= k; i++){
            int max = maxHeap.poll();
            int newNum = (int) Math.floor(Math.sqrt(max));
            maxHeap.add(newNum);
        }

        while(!maxHeap.isEmpty()){
            res += maxHeap.poll();
        }
        return res;
    }
}
