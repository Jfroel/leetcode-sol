class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> compToIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (compToIndexMap.containsKey(nums[i])) {
                int[] res = {compToIndexMap.get(nums[i]), i};
                return res;
            } else {
                compToIndexMap.put(target-nums[i], i);
            }
        }
        return null;
    }
}
