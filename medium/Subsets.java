// leetcode 78
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, subsets, new ArrayList<>(), 0);
        return subsets;
    }
    
    public void generateSubsets(int[] nums, List<List<Integer>> subsets, List<Integer> subset, int count) {
        if (count == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        
        generateSubsets(nums, subsets, subset, count + 1);
        subset.add(nums[count]);
        generateSubsets(nums, subsets, subset, count + 1);
        subset.remove(subset.size() - 1);
    }

}