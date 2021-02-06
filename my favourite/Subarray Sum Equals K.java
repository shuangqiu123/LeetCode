// similar question 437. Path Sum III

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        // the sum from [0,i]
        int sum = 0;
        // solve the corner case for all 0s
        map.put(0,1);
        
        for (int i=0;i<nums.length;++i) {
            sum += nums[i];
            
            // [0,i] - [0,j] = k ([i,j])
            if (map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            
            // record for the count of the sum from [0,i]
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}