import java.util.*;

public class Bellman_Ford_Algorithm {
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
        graph[0].add(new Edge(0, 2, -2));

        graph[1].add(new Edge(1, 2, 5));
        graph[1].add(new Edge(1, 3, -10));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, -1));

        graph[4].add(new Edge(4, 3, 4));
        graph[4].add(new Edge(4, 5, -2));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 6, -1));

        graph[6].add(new Edge(6, 0, 7));
    }

    public static void bellman(ArrayList<Edge> graph[], int src, int V) {
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k < V - 1; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }
        // -ve weight cycles
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dest;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                    System.out.println("Negative weight cycle");
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        bellman(graph, 0, V);
    }
}
