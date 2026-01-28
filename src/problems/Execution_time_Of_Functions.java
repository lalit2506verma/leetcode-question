package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Execution_time_Of_Functions {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7");
        System.out.println(Arrays.toString(exclusiveTime(2, list)));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] executionTime = new int[n];

        Stack<int[]> stack = new Stack<>();

        for(String log : logs){
            String[] func = log.split(":");
            int id =  Integer.parseInt(func[0]);
            String action = func[1];
            int startTime = Integer.parseInt(func[2]);

            if(action.equals("start")){
                stack.push(new int[]{id, startTime, 0}); // [id, startTime, childTime]
            }
            else{
                int[] currFunc = stack.pop();
                int executeTime = startTime -  currFunc[1] + 1;
                int finalTime = executeTime - currFunc[2];
                executionTime[currFunc[0]] += finalTime;

                // updating parent function
                if (!stack.isEmpty()) { stack.peek()[2] += executeTime; }
            }
        }

        return executionTime;
    }

}
