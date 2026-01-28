package problems;

import java.util.Arrays;

public class Increment_Binary_Number {
    public static void main(String[] args) {
        int[] arr = {9, 9, 0, 9, 9, 9};
        System.out.println(Arrays.toString(addOne(arr)));
    }

    public static int[] addOne(int[] digits) {
        int n =  digits.length;
        int i = n-1;
        if(digits[i] < 9){
            digits[i] += 1;
            return digits;
        }
        else{
            int count  = 0;
            while(i >= 0 && digits[i] == 9){
                digits[i] = 0;
                count++;
                i--;
            }

            if(count == n){
                int[] res = new int[n+1];
                res[0] = 1;
                return res;
            }
            else{
                digits[n - count-1] += 1;
                return digits;
            }
        }

    }
}
