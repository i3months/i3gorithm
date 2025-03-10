import java.util.*;

class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int node : nodes) graph.put(node, new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
                
        Set<Integer> visited = new HashSet<>();
        int countHoljak = 0;   
        int countReverse = 0;  
                
        for (int node : nodes) {
            if (!visited.contains(node)) {
                List<Integer> component = new ArrayList<>();                
                Queue<Integer> queue = new LinkedList<>();
                
                queue.offer(node);
                visited.add(node);
                
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    component.add(cur);
                    for (int nei : graph.get(cur)) {
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            queue.offer(nei);
                        }
                    }
                }
                
                int rootCandidatesHoljak = 0;
                int rootCandidatesReverse = 0;
                
                for (int v : component) {
                    int degree = graph.get(v).size();
                    if (v % 2 == 1) { 
                        if (degree % 2 == 1) {
                            rootCandidatesHoljak++;
                        }
                        if (degree % 2 == 0) {
                            rootCandidatesReverse++;
                        }
                    } else { 
                        if (degree % 2 == 0) {
                            rootCandidatesHoljak++;
                        }
                        if (degree % 2 == 1) {
                            rootCandidatesReverse++;
                        }
                    }
                }
                if (rootCandidatesHoljak == 1) {
                    countHoljak++;
                }
                if (rootCandidatesReverse == 1) {
                    countReverse++;
                }
            }
        }
        return new int[]{countHoljak, countReverse};
    }
}
