// O(n) runtime
// using O(n) space to store the min wall height at each point.
// height:   0 1 0 2 1 0 1 3 2 1 2 1
// maxLeft:  0 1 1 1 2 2 2 2 3 3 3 3
// maxRight: 3 3 3 3 3 3 3 2 2 2 1 0 
// mins:     0 1 1 1 2 2 2 2 2 2 1 0
class Solution1 {
  public int trap(int[] height) {
      int n = height.length;
      if (n <= 2) return 0;
      int total = 0;
      int max = 0;
      int[] mins = new int[n];
      for (int i = 0; i < n; i++) {
        mins[i] = max;
        max = Math.max(max, height[i]);
      }
      max = 0;
      for (int i = n-1; i >= 0; i--) {
        mins[i] = Math.min(max, mins[i]);
        max = Math.max(max, height[i]);
      }
      for (int i = 0; i < n; i++) {
        int vol = mins[i] - height[i];
        if (vol > 0) total += vol;
      }
      return total;
  }
}

// Time: O(n), Space: O(1)
// walk to pointers inwards and only compute volumes for 
// the side you know the min.

class Solution2 {
  public int trap(int[] height) {
      int n = height.length;
      if (n <= 2) return 0;
      int total = 0;
      int l = 0;
      int r = n - 1;
      int maxL = height[l];
      int maxR = height[r];
      while (l < r) {
        if (maxL < maxR) {
          l++;
          maxL = Math.max(maxL, height[l]);
          total += maxL - height[l];
        } else {
          r--;
          maxR = Math.max(maxR, height[r]);
          total += maxR - height[r];
        }
      }
      return total;
  }
}