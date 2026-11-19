class Solution {
    public int maxProfit(int[] prices) {
        // // brute force version o(n * n)
        // int max_profit = 0;

        // for (int i = 0; i < prices.length; i++) {
        //     for(int j = i + 1; j < prices.length; j++ ) {
        //         int profit = prices[j] - prices[i];
        //         max_profit = Math.max(prices[j] - prices[i], max_profit);
        //     }
        // }
        // return max_profit;

        int l = 0; 
        int r = 1;
        int max_profit = 0;

        while (r < prices.length) {
            if (prices[r] > prices[l]) {
                int profit = prices[r] - prices[l];
                max_profit = Math.max(profit, max_profit);
            } else {
                // 永远把我的买入日选为最便宜的一天
                l = r;
            }
            r++;
        }
        return max_profit;
    }





}
