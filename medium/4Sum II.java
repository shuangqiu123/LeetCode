class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = A.length;
        // reduced time complexity from O(n^4) to O(n^2)
        for (int i=0;i<n;++i) {
            for (int j=0;j<n;++j) {
                int sum = A[i]+B[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int res = 0;
        for (int i=0;i<n;++i) {
            for (int j=0;j<n;++j) {
                int sum = C[i]+D[j];
                if (map.containsKey(-sum)) {
                    res += map.get(-sum);
                }
            }
        }
        
        return res;
    }
}