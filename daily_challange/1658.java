class Solution {
    public int minOperations(int[] nums, int x) {
        // Not my original algorithm

        // The goal here is to find a sub array with a sum equal
        // to that of the array total minus the goal value (x)
        // if we can find that, we know that the set difference
        // between the original array and the sub array is the elements
        // that total to the goal value.
        // From there it is just a matter of finding the longest sub
        // array, since that means we removed the fewest elements (fewest ops)
        
        int maxLen = -1, curSum = 0, left = 0;
        int targetSum = -x;
        int n = nums.length;
        for (int num : nums) {
            targetSum += num;
        }

        if (targetSum == 0) {
            // original array and sub array are equiv, too easy!
            return n;
        }

        // To find the sub array, we will use a sliding window
        // and just keep a running total of the sum of the window.
        // Whenever the window has a total greater than the target
        // remove an element from the right

        for (int right = 0; right < n; right++) {
            curSum += nums[right];
            while (curSum > targetSum && left <= right) {
                curSum -= nums[left++];
            }
            if (curSum == targetSum) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen == -1 ? maxLen : n - maxLen; 
    }

    // simple recursive brute force approach
    // public int minOperations(int[] nums, int x) {
    //     int l = 0;
    //     int r = nums.length - 1;
    //     return helper(nums, x, l, r, 0);
    // }

    // private int helper(int[] nums, int x, int l, int r, int layer) {
    //     if (x < 0) {
    //         return -1;
    //     } else if (x == 0) {
    //         return layer;
    //     } else if (l > r) {
    //         return -1;
    //     }

    //     // left side 
    //     int leftX = x - nums[l];
    //     int leftRes = helper(nums, leftX, l + 1, r, layer + 1);

    //     // right side
    //     int rightX = x - nums[r];
    //     int rightRes = helper(nums, rightX, l, r - 1, layer + 1);

    //     if (leftRes != -1 && rightRes != -1) {
    //         return Math.min(leftRes, rightRes);
    //     } else {
    //         return Math.max(leftRes, rightRes);
    //     } 
    // }
}
