package problems;

public class Smallest_Integer_Divisible_by_K {
    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(1));
    }

    public static int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0){
            return -1;
        }

        int len = 1;
        int rem = 1;

        while(rem != 0){
            if(rem % k == 0){
                return len;
            }
            rem = ((rem * 10) + 1) % k;
            len++;
        }

        return len;
    }
}
