// house robber II == solve house robber twice
class Solution {
  public int rob(int[] nums) {
      int n = nums.length;
      if (n == 1) {
        return nums[0];
      }

      // divide search space into 0 to n-1 and 1 to n since 0 and n can't both be robbed
      int prev2 = 0;
      int prev1 = 0;
      int cur;
      for (int i = 0; i < n-1; i++) {
          cur = Math.max(prev1, prev2 + nums[i]);
          prev2 = prev1;
          prev1 = cur;
      }
      int saved = prev1;
      prev2 = 0;
      prev1 = 0;
      for (int i = 1; i < n; i++) {
          cur = Math.max(prev1, prev2 + nums[i]);
          prev2 = prev1;
          prev1 = cur;
      }
      return Math.max(prev1, saved);
  }
}