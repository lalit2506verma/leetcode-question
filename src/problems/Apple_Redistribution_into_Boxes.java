package problems;

import java.util.Arrays;

public class Apple_Redistribution_into_Boxes {

    public static void main(String[] args) {

    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = capacity.length;
        Arrays.sort(capacity);

        int totalApple = 0;

        for(int a : apple){
            totalApple += a;
        }

        int count = 0;
        for(int i = n-1; i >= 0; i--){
            if(totalApple <= 0){
                break;
            }

            totalApple -= capacity[i];
        }

        return count;
    }
}
