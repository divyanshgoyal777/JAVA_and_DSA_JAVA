import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra_Algorithm {
    public static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 5));
        graph[1].add(new Edge(1, 3, 10));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 11));

        graph[4].add(new Edge(4, 3, 4));
        graph[4].add(new Edge(4, 5, 2));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 0, 7));
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int dest;

        public Pair(int n, int d) {
            this.node = n;
            this.dest = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dest - p2.dest;
        }
    }

    // O(E + E log V)
    public static void dijkstra(ArrayList<Edge> graph[], int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if (dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        dijkstra(graph, 0, V);
    }
}
