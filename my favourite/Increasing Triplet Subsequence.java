class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] piles = new int[3];
        int size = 0;

        //O(n)
        for (int num : nums) {
            int i=0,j=size;

            // O(1)
            while (i < j) {
                int mid = i+ (j-i)/2;
                if (num <= piles[mid]) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
                
            }
            if (i == size) piles[size++] = num;
            else piles[i] = num;
            
            if (size == 3) return true;
        }
        
        return false;
    }
}