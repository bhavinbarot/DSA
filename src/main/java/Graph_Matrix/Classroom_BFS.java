package Graph_Matrix;

import java.util.*;

public class Classroom_BFS {
    static class Edge{
        int source;
        int destination;
        int weight;
        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        public Edge(int source, int destination){
            this.source = source;
            this.destination = destination;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

    }
    public static void bfs(ArrayList<Edge>[] graph, int V, boolean[] vis, int startIndex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        vis[startIndex] = true;

        while (!queue.isEmpty()) {
            int current = queue.remove();
            System.out.print(current + " ");

            for (int i = 0; i < graph[current].size(); i++) {
                Edge e = graph[current].get(i);
                if (!vis[e.destination]) {
                    queue.add(e.destination);
                    vis[e.destination] = true;
                }
            }
        }
    }
    public static void main(String[] args){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean vis[] = new boolean[V];
        System.out.println("Expected : 0 1 2 3 4 5 6");
        System.out.print("Actual   : ");
        for(int i=0;i<vis.length;i++){
            if(vis[i]==false){
                bfs(graph, V, vis, i);
            }
        }


    }
}
