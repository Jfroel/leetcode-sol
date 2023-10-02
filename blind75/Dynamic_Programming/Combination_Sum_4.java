// bottom up dp
class Solution {
  public int combinationSum4(int[] nums, int target) {
    // for each sub target, sum up all the ways to get that target
    int[] dp = new int[target+1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int num : nums) {
        int remainder = i - num;
        if (remainder >= 0) {
          dp[i] += dp[remainder];
        }
      }
    }
    return dp[target];
  }
}

// top down dp
class Solution2 {
  public int combinationSum4(int[] nums, int target) {
    // traverse down the tree until you hit target = 0
    // use a memo to prune branches
    return topDown(nums, target, new HashMap<>());
  }
  private int topDown(int nums[], int target, HashMap<Integer, Integer> memo) {
    if (memo.containsKey(target)) return memo.get(target);
    if (target == 0) {
      return 1;
    } else if (target < 0) {
      return 0;
    }
    int combinations = 0;
    for (int num : nums) {
      combinations += topDown(nums, target - num, memo);
    }
    memo.put(target, combinations);
    return combinations;
  }
}