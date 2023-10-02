class Solution1 {
  public boolean canJump(int[] nums) {
    return topDown(nums, 0);
  }
  private boolean topDown(int[] nums, int index) {
    if (index == nums.length-1) return true;
    if (nums[index] == 0) return false;
    boolean canJump = false;
    for (int i = 1; i <= nums[index]; i++) {
      if (index + 1 < nums.length && topDown(nums, index + i))  {
        canJump = true;
        break;
      }
    }
    return canJump;
  }
}

// top down dp, doesn't really improve much
class Solution2 {
  public boolean canJump(int[] nums) {
    return topDown(nums, 0, new HashMap<Integer, Boolean>());
  }
  private boolean topDown(int[] nums, int index, HashMap<Integer, Boolean> memo) {
    if (memo.containsKey(index)) return memo.get(index); 
    if (index == nums.length-1) return true;
    if (nums[index] == 0) return false;
    boolean canJump = false;
    for (int i = 1; i <= nums[index]; i++) {
      if (index + 1 < nums.length && topDown(nums, index + i, memo))  {
        canJump = true;
        break;
      }
    }
    memo.put(index, canJump);
    return canJump;
  }
}

// bottom up dp 
class Solution3 {
  public boolean canJump(int[] nums) {
    // bottom up
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, -1); // -1 -> uninit, 0 -> false, 1 -> true
    
    // for each index working backwards, can you reach the end index?
    dp[n-1] = 1; // the end is always reachable from the last index

    for (int i = n-2; i >= 0; i--) {
      if (nums[i] == 0) {
        // zero jumps can't get nowhere
        dp[i] = 0;
        continue;
      }

      // can the thinks you can reach reach the end themselves.
      int canJump = 0;
      for (int jump = 1; jump <= nums[i]; jump++) {
        if (jump + i < n && dp[jump + i] == 1) {
          canJump = 1;
          break;
        }
      }
      dp[i] = canJump;
    }
    return dp[0] == 1;
  }
}

class Solution4 {
  public boolean canJump(int[] nums) {
    // greedy
    // at each index calculate how far you can reach
    // if you hit an index that is greater than your reach
    // then you fail
    int maxReach = 0;
    for (int i = 0; i < nums.length; i++) {
      if (maxReach < i) return false;
      maxReach = Math.max(maxReach, i + nums[i]);
    }
    return true;
  }
}