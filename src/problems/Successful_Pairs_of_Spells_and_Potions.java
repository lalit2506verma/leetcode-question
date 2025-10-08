package problems;

import java.util.Arrays;

public class Successful_Pairs_of_Spells_and_Potions {
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};

        System.out.println(Arrays.toString(successfulPairs(spells, potions, 7)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];

        // Sorting the portion
        Arrays.sort(potions);

        // find the least strength portion for ith spell to make success
        for(int i = 0; i < n; i++){
            int leastPossibleIdx = binarySearch(potions, spells[i], success);
            if(leastPossibleIdx != -1){
                res[i] = m - leastPossibleIdx;
            }
        }

        return res;
    }

    private static int binarySearch(int[] potions, int i, long target){
        int s = 0;
        int e = potions.length - 1;
        int res = -1;

        while(s <= e){
            int mid = s + (e - s) / 2;

            long product = (long) potions[mid] * i;
            if(product >= target){
                res = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }

        return res;
    }
}
