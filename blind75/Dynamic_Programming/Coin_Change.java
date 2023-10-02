class Solution {
  public int coinChange(int[] coins, int amount) {
      if (amount == 0) return 0;
      int n = coins.length;
      int[] dp = new int[amount+1];

      // for each sub amount building upwards to the full amount,
      // 1. try each coin and find the one that gives the min remainder.
      // 2. check the required coins for that remainder.
      // 3. store the result as using one more coin.

      for (int subAmount = 1; subAmount <= amount; subAmount++) {
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
          int remainder = subAmount - coin;
          if (remainder >= 0) {
            min = Math.min(min, dp[remainder]);
          }
        }
        if (min != Integer.MAX_VALUE){
          dp[subAmount] = min + 1;
        } else {
          dp[subAmount] = min;
        }
      }
      return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
  }
}