package problems;

public class Calculate_Money_in_Leetcode_Bank {
    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }

    public static int totalMoney(int n) {
        int lastMonday = 1;
        int weeks = n / 7;
        int rem = n % 7;

        int sum = 0;

        for(int i= 0; i < weeks; i++){
            int lastDay = lastMonday;
            for(int j = 0; j < 7; j++){
                sum += lastDay;
                lastDay++;
            }

            lastMonday++;
        }

        for(int i = 0; i < rem; i++){
            sum += lastMonday;
            lastMonday++;
        }

        return sum;
    }
}
