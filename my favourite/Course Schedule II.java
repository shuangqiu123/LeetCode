/**
classic topological sorting problem to find DAG
 */
class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[][] graph = new int[n][n];
        int[] indegree = new int[n];

        // construct the adjacent matrix of the graph
        for (int i=0;i<prerequisites.length;++i) {
            if (graph[prerequisites[i][1]][prerequisites[i][0]]==0)
                indegree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        Queue<Integer> queue = new ArrayDeque<>();

        // initialise the queue with 0 indegree
        for (int i=0;i<n;++i) {
            if (indegree[i] == 0) queue.add(i);
        }
        int[] res = new int[n];
        int index = 0;
        while (!queue.isEmpty()) {
            int j=queue.poll();
            indegree[j]--;
            res[index++] = j;
            for (int k=0;k<graph[j].length;k++) {
                if (graph[j][k] > 0) {
                    indegree[k]--;
                    //update the queue
                    if (indegree[k] == 0) {
                        queue.offer(k);
                    }
                }
            }
        }
        if (index < res.length) return new int[0];
        
        return res;
    }
}

// recursive way to be done...