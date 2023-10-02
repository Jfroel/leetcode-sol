// bottom up tabulation with space opt

class Solution {
  public int climbStairs(int n) {
      // each stair is just the sum of the last two stairs
      if (n == 1) return 1;
      int prev = 1;
      int prevPrev = 1;
      int cur = 1;
      for (int i = 2; i <= n; i++) {
        cur = prev + prevPrev;
        prevPrev = prev;
        prev = cur;
      }
      return cur;
  }
}