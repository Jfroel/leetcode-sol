// bottom up tab
class Solution {
  public int uniquePaths(int m, int n) {
    // use an array to track the cur column and work from last to first
    // last col will be all 1s
    // when working backwards each tile has a value of below + right
    // b4 update dp[j] is right, dp[j-1] is below
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[j] += dp[j-1];
      }
    } 
    return dp[n-1];
  }
}

// 4 x 5 example:
// X X X X 1 
// X X X X 1
// X X X X 1
// X X X X 1

// X X X 4 1 
// X X X 3 1
// X X X 2 1
// X X X 1 1

// X X 10 4 1 
// X X  6 3 1
// X X  3 2 1
// X X  1 1 1

// X 20 10 4 1 
// X 10  6 3 1
// X  4  3 2 1
// X  1  1 1 1

// 35 20 10 4 1 
// 15 10  6 3 1
//  5  4  3 2 1
//  1  1  1 1 1