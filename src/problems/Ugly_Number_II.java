package problems;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Ugly_Number_II {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(nthUglyNumber(20));
    }

    public static int nthUglyNumber(int n) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();

        int count = 0;
        q.add(1);

        while(true){
            if(count == n-1){
                break;
            }
            int top = q.peek();
            int mul2 = top*2;
            int mul3 = top*3;
            int mul5 = top*5;

            if(!set.contains(mul2)){
                q.add(mul2);
                set.add(mul2);
            }

            if(!set.contains(mul3)){
                q.add(mul3);
                set.add(mul3);
            }

            if(!set.contains(mul5)){
                q.add(mul5);
                set.add(mul5);
            }
            System.out.print(q.poll()+ " ");
            count++;
        }

        return q.poll();

    }
}
