class Solution {
    int[][] graph;
    int[] indegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites);

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (graph[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
        
    }
    
    public void buildGraph(int n, int[][] ps) {
        graph = new int[n][n];
        indegree = new int[n];
        for (int i=0;i<ps.length;++i) {
            if (graph[ps[i][1]][ps[i][0]]==0)
                indegree[ps[i][0]]++;
            graph[ps[i][1]][ps[i][0]] = 1;
        }
    }
}