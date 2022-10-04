class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int center = left + (right-left)/2;
            if (nums[center] < nums[right]) {
                right = center;
            } else  {
                left = center+1;
            } 
        }
        return nums[left];
    }
}
