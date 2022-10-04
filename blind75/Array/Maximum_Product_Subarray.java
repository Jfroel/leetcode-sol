class Solution {
    public int maxProduct(int[] nums) {
        int total = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, total *= nums[i]);
            if (nums[i] == 0) total = 1;
        }
        total = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            max = Math.max(max, total *= nums[i]);
            if (nums[i] == 0) total = 1;
        }
        return max;
    }
}
