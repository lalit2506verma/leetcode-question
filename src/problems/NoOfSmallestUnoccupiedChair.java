package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class NoOfSmallestUnoccupiedChair {
    public static void main(String[] args) {
        int[][] times = {{3,10},{1,5},{2,6}};

        System.out.println(smallestChair(times, 1));
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        Stack<Integer> stack = new Stack<>();

        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        int count = 0;

        for(int i = 0; i <= targetFriend; i++){
            if(stack.isEmpty()){
                stack.push(times[i][1]);  // adding the leaving time in the stack
                continue;
            }

            if(times[i][0] < stack.peek()){
                stack.push(times[i][1]);
            }
            else{
                stack.pop();
                i--;
            }
        }
        return stack.size();
    }
}
