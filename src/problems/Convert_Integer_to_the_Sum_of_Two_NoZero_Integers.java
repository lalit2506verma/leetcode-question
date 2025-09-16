package problems;

import java.util.Arrays;

public class Convert_Integer_to_the_Sum_of_Two_NoZero_Integers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNoZeroIntegers(11)));
    }

    public static int[] getNoZeroIntegers(int n) {
        for(int i = 0; i < n; i++){
            int j = n - i;
            if(checkNonZero(i) && checkNonZero(j)){
                return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }

    public static boolean checkNonZero(int n){
        if(n == 0) return true;

        while(n > 0){
            int rem = n % 10;
            if(rem == 0){
                return false;
            }
            n /= 10;
        }

        return true;
    }
}
