class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
    
        
        for (int i=1;i<=numRows && i<=2;++i) {
            List<Integer> lst = new ArrayList<>();
            for (int j=0;j<i;++j) {
                lst.add(1);
            }
            res.add(lst);
        }
        
        for (int i=2;i<numRows;++i) {
            List<Integer> lst = new ArrayList<>();
            lst.add(1);
            List<Integer> tmp = res.get(i-1);
            for (int j=1;j<tmp.size();++j) {
                lst.add(tmp.get(j) + tmp.get(j-1));
            }
            lst.add(1);
            
            res.add(lst);
        }
        
        return res;
    }
}