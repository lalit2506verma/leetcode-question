package problems;

import java.util.Arrays;

public class Maximize_Happiness_of_Selected_Children {
    public static void main(String[] args) {

    }

    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;

        Arrays.sort(happiness);
        long decrement = 0;
        long total = 0;

        for(int i = n-1; i >= 0; i--) {
            if (k > 0 && happiness[i] - decrement > 0) {
                total += happiness[i] - decrement;
            }

            k--;
            decrement++;
        }

        return total;
    }
}
