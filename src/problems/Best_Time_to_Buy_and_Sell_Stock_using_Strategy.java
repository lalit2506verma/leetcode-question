package problems;

public class Best_Time_to_Buy_and_Sell_Stock_using_Strategy {
    public static void main(String[] args) {
        int[] prices = {2,3,2,3};
        int[] strategies = {-1,-1,-1,-1};

        System.out.println(maxProfit(prices, strategies, 2));
    }

    public static long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        // prefix Array

        int[] prefix = new int[n];
        prefix[0] = prices[0] * strategy[0];

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + (prices[i] * strategy[i]);
        }

        long maxProfit = Integer.MIN_VALUE;

        for(int i = k-1; i < n; i++){
            int j = i - k + 1;

            int leftSum = 0;
            if( j > 0){
                leftSum = prefix[j-1];
            }

            int rightSum = prefix[n-1] - prefix[i];

            int sum = 0;

            for(int l = j + k/2; l <= i; l++){
                sum += prices[l];
            }

            maxProfit = Math.max(maxProfit, leftSum + rightSum + sum);
        }

        return Math.max(maxProfit, prefix[n-1]);
    }
}
