import java.util.*;

public class DFS {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1, 5));
        graph.put(4, Arrays.asList(1, 2));
        graph.put(5, Arrays.asList(3));

        Set<Integer> visited = new HashSet<>();
        dfs(0, graph, visited);
    }

    static void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        System.out.print(node + " ");
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            dfs(neighbor, graph, visited);
        }
    }
}

//Output:
// 0 1 3 5 4 2 
