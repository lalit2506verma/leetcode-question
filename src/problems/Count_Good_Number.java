package problems;

public class Count_Good_Number {

    static final int MOD = 1_000_000_007;
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(5));
    }

    public static int countGoodNumbers(long n) {
        return count(n, 1);
    }

    public static int count(long n, int res){
        if(n == 0){
            return res;
        }
        // n is even but treated as odd
        if(n % 2 == 0){
            res =  (res * 4) % MOD;
        }
        else{
            res = (res * 5) % MOD;
        }

        return count(n-1, res);
    }
}
