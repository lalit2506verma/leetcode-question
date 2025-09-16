package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maximun_Even_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            List<Long> divisors = findDivisor((long)b);

            long maxEvenSum = -1;

            for(long num : divisors){
                long mul = a * num;
                long div = b / num;

                if((mul + div) % 2 == 0){
                    maxEvenSum = Math.max(maxEvenSum, mul + div);
                }
            }
            System.out.println(maxEvenSum);
        }
    }

    private static List<Long> findDivisor(Long n) {
        List<Long> divisors = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }

        return divisors;
    }



}
