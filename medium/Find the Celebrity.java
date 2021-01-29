/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
/**
Greedy algorithm
 */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;

        // first iteration is to sift all the non-candidate, leaving only one possible candidate
        for (int i=1;i<n;++i) {
            if (knows(candidate,i)) {
                candidate = i;
            } 
        }
        
        // second round check if the candidate is valid or not
        for (int i=0;i<n;++i) {
            if (i==candidate) continue;
            if (knows(candidate,i) || !knows(i,candidate)) {
                return -1;
            } 
        }
        return candidate;
    }
}