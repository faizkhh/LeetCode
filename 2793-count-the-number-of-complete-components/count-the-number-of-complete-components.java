import java.util.*;

public class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        // Step 2: Traverse each component
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> componentNodes = new ArrayList<>();
                dfs(i, graph, visited, componentNodes);

                // Step 3: Count edges in the component
                int edgeCount = 0;
                for (int node : componentNodes) {
                    edgeCount += graph.get(node).size();
                }
                edgeCount /= 2; // Since it's undirected, every edge is counted twice

                int v = componentNodes.size();
                if (edgeCount == v * (v - 1) / 2) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> componentNodes) {
        visited[node] = true;
        componentNodes.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, componentNodes);
            }
        }
    }
}
