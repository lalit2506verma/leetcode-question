package problems;

public class Best_Time_to_Buy_and_Sell_Stock_V {
    static long[][][] dp = new long[1001][501][3];

    public static void main(String[] args) {
        int[] prices = {1,7,9,8,2};
        System.out.println(maximumProfit(prices, 2));
    }

    public static long maximumProfit(int[] prices, int k) {
        int n  = prices.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                for(int l = 0; l < 3; l++) {
                    dp[i][j][l] = Integer.MAX_VALUE;
                }
            }
        }
        return helper(prices, 0, 0, k);
    }


    public static long helper(int[] prices, int idx, int CASE, int k) {

        // base case - out of bound
        if(idx == prices.length){
            if(CASE == 0){
                return 0;
            }

            return Integer.MIN_VALUE;
        }

        if(dp[idx][k][CASE] != Integer.MAX_VALUE){
            return dp[idx][k][CASE];
        }

        // not take
        long notTake = helper(prices, idx+1, CASE, k);

        long take = Integer.MIN_VALUE;

        if(k > 0){
            // we have 3 case

            if(CASE == 1) { // sell
                take = prices[idx] + helper(prices, idx + 1, 0, k-1);
            }
            else if(CASE == 2) { // buy
                take = -prices[idx] + helper(prices, idx + 1, 0, k-1);
            }
            else {
                take = Math.max(
                        -prices[idx] + helper(prices, idx + 1, 1, k),
                         prices[idx] + helper(prices, idx + 1, 2, k)
                );
            }
        }

        return dp[idx][k][CASE] = Math.max(take, notTake);
    }


}
