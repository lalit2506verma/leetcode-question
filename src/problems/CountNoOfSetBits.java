package problems;

public class CountNoOfSetBits {
    public static void main(String[] args) {
        System.out.println(setBits(2));
    }

    public static int setBits(int n){
        int count = 0;
        while(n > 0){
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
