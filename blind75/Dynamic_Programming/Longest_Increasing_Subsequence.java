class Solution {
  public int lengthOfLIS(int[] nums) {
    // in an array, store the longest seen sub sequence
    // when you hit a number that breaks the sequence 
    // put it in the array, replacing the value it is smaller than
    // this way the array only grows when you find bigger numbers 
    // but you don't need to track the individual sub sequences
    int n = nums.length;
    int[] dp = new int[n];
    int len = 0;
    for (int num : nums) {
      if (len == 0 || dp[len-1] < num) {
        dp[len] = num;
        ++len; 
      } else {
        searchAndReplace(dp, len, num);
      }
    }
    return len;
  }
  private void searchAndReplace(int[] dp, int len, int num) {
    int l = 0;
    int r = len;
    int mid;
    while (l < r) {
      mid = l + (r-l)/2;
      if (dp[mid] >= num) {
        r = mid;
      } else {
        l = mid+1;
      }
    }
    if (l < len && dp[l] < num) l++;
    dp[l] = num;
  }

  // recursive dp approach with memo
  // private int bruteForceDP(int[] nums, int index, int lastIndex, int[] dp) {
    //   if (index >= nums.length) return 0;
    //   if (dp[lastIndex+1] != -1) return dp[lastIndex+1];
    //   int take = 0;
    //   int dontTake = bruteForceDP(nums, index+1, lastIndex, dp);
    //   if (lastIndex == -1 || nums[lastIndex] < nums[index]) {
    //     take = bruteForceDP(nums, index+1, index, dp) + 1;
    //   }
    //   int max = Math.max(take, dontTake);
    //   dp[lastIndex+1] = max;
    //   return max;
    // }
}