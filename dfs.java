import java.util.*;

class DFS {
  private LinkedList<Integer>[] adj;
  private boolean visited[];

  public DFS(int V) {
    adj = new LinkedList[V];
    visited = new boolean[V];
    for (int i = 0; i < V; ++i)
      adj[i] = new LinkedList<>();
  }

  void addEdge(int u, int v) {
    adj[u].add(v);
  }

  void DFSUtil(int v) {
    visited[v] = true;
    System.out.print(v + " ");  // Print visited node (can be modified for other actions)
    for (int x : adj[v])
      if (!visited[x])
        DFSUtil(x);
  }

  void DFS(int v) {
    visited = new boolean[adj.length]; // Reset visited for disconnected graphs
    DFSUtil(v);
  }

  public static void main(String args[]) {
    DFS g = new DFS(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Depth First Traversal (starting from vertex 2)");
    g.DFS(2);
  }
}

//Output:
// Following is Depth First Traversal (starting from vertex 2)
// 2 0 1 3 
