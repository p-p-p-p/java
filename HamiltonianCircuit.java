import java.util.*;

public class HamiltonianCircuit {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 0, 1, 0},
            {0, 1, 1, 0, 1},
            {1, 1, 0, 1, 0}
        };
        hamiltonianCircuit(graph);
    }

    static void hamiltonianCircuit(int[][] graph) {
        int n = graph.length;
        int[] path = new int[n];
        Arrays.fill(path, -1);
        path[0] = 0;
        if (!hamiltonianCircuitUtil(graph, path, 1))
            System.out.println("No Hamiltonian Circuit exists");
    }

    static boolean hamiltonianCircuitUtil(int[][] graph, int[] path, int pos) {
        if (pos == graph.length) {
            if (graph[path[pos - 1]][path[0]] == 1) {
                System.out.println("Hamiltonian Circuit: " + Arrays.toString(path));
                return true;
            }
            return false;
        }

        for (int v = 1; v < graph.length; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                if (hamiltonianCircuitUtil(graph, path, pos + 1))
                    return true;
                path[pos] = -1;
            }
        }
        return false;
    }

    static boolean isSafe(int v, int[][] graph, int[] path, int pos) {
        if (graph[path[pos - 1]][v] == 0)
            return false;
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;
        return true;
    }
}
// Output:
// Hamiltonian Circuit: [0, 1, 2, 3, 4]
