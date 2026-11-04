import java.util.*;

public class Prim_Algorithm {
    public static class Edge {
        int src, dest, cost;

        Edge(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[1].add(new Edge(1, 3, 30));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static class Pair implements Comparable<Pair> {
        int node, cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void prim(ArrayList<Edge> graph[], int Vertex) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[Vertex];
        pq.add(new Pair(0, 0));
        int mstCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.node]) {
                vis[curr.node] = true;
                mstCost += curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.cost));
                    }
                }
            }
        }

        System.out.println("Cost of minimum spanning tree: " + mstCost);
    }

    public static void main(String args[]) {
        int Vertex = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[Vertex];
        createGraph(graph);

        for (int i = 0; i < Vertex; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                System.out.println(e.src + " " + e.dest + " " + e.cost);
            }
        }

        prim(graph, Vertex);
    }
}
