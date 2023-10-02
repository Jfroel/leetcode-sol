class Solution {
    public int maxProfit(int[] prices) {
        int maxCur = 0, totalMax = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            totalMax = Math.max(maxCur, totalMax);
        }
        return totalMax;
    }
}
