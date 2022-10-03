class Solution {
    public int[] productExceptSelf(int[] nums) {
        // we need to multiply every number by what is on its right and what is on its left
        // to do this in O(n), as we move from the right to the left, total up the products of the numbers
        // then do the same fro the left
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int runningTotal = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] *= runningTotal;
            runningTotal *= nums[i];
        }
        return res;
    }
}
