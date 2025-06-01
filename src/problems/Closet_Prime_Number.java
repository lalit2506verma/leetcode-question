package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Closet_Prime_Number {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestPrimes(10, 19)));
    }

    public static int[] closestPrimes(int left, int right) {
        boolean[] arr = new boolean[right+1];

        // Sieve Of Eratosthenes
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i*i < arr.length; i++) {
            if(!arr[i]){
                for (int j = 2; i*j < arr.length; j++) {
                    arr[i*j] = true;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if(!arr[i]){
                primes.add(i);
            }
        }

        if(primes.size() < 2){
            return new int[]{-1, -1};
        }

        int[] res = new int[2];
        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < primes.size(); i++) {
            int gap = primes.get(i) - primes.get(i-1);
            if(gap < minGap){
                minGap = gap;
                res[0] = primes.get(i-1);
                res[1] = primes.get(i);
            }
        }

        return res;
    }
}
