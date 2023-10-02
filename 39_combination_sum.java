class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Essentially, we just need to iterate through the tree until we find all
        // the combinations that work. Also need to sort 
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(res, curList, candidates, 0, target);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curList, 
                            int[] nums, int index, int remainder) {
        if (remainder == 0) {
            res.add(new ArrayList<Integer>(curList));
        } else if (remainder > 0) {
            int num;
            for (int i = index; i < nums.length; i++) {
                num = nums[i];
                curList.add(num);
                backtrack(res, curList, nums, i, remainder - num);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
