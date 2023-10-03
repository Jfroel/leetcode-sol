class Solution {
  public int networkDelayTime(int[][] times, int n, int k) {
      HashMap<Integer, ArrayList<Edge>> graph = buildGraph(times); 
      PriorityQueue<Edge> minHeap 
        = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
      HashSet<Integer> visited = new HashSet<>();
      int res = 0;
      minHeap.add(new Edge(k, 0));
      while (!minHeap.isEmpty()) {
        Edge edge = minHeap.poll();
        int node = edge.node;
        int weight = edge.weight;
        if (visited.contains(node)) continue;
        visited.add(node);
        res = Math.max(res, weight);
        if (!graph.containsKey(node)) continue;
        for (Edge child : graph.get(node)) {
          if (!visited.contains(child.node)) {
            child.weight += weight;
            minHeap.add(child);
          } 
        }
      }
      return visited.size() == n ? res : -1;
  }
  private HashMap<Integer, ArrayList<Edge>> buildGraph(int[][] times) {
    HashMap<Integer, ArrayList<Edge>> res = new HashMap<>();
    for (int[] time : times) {
      Edge edge = new Edge(time[1], time[2]);
      if (!res.containsKey(time[0])) {
        res.put(time[0], new ArrayList<>());
      }
      res.get(time[0]).add(edge);
    }
    return res;
  }
}

class Edge {
  public int node;
  public int weight;
  public Edge() {
    this(0, 0);
  }
  public Edge(int n, int w) {
    node = n;
    weight = w;
  }
}