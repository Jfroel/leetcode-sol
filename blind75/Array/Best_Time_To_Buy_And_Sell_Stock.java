class Solution {
    public int maxProfit(int[] prices) {
        int maxCurr = 0, totalMax = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCurr = Math.max(0, maxCurr += prices[i] - prices[i-1]);
            totalMax = Math.max(maxCurr, totalMax);
        }
        return totalMax;
    }
}
