// bottom up dp
class Solution {
  public int rob(int[] nums) {
      int n = nums.length;
      if (n == 1) {
        return nums[0];
      } 
      // at each house either rob or skip. 
      // just preform the same sub problem over and over again
      // prevPrev is the max amount for two houses ago
      // prev is the max amount for the last house
      int prevPrev = 0;
      int prev = 0;
      int cur = 0;
      for (int num : nums) {
        cur = Math.max(prev, prevPrev + num);
        prevPrev = prev;
        prev = cur;
      }
      return prev;
  }
}