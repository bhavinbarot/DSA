package Graph_Matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Classroom_DFS {
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

    public static void dfs(ArrayList<Edge>[] graph, int currentNode, boolean[] visited){
        System.out.println(currentNode + "");
        visited[currentNode] = true;

        for(int i=0; i< graph[currentNode].size();i++){
            Edge e = graph[currentNode].get(i);
            if(visited[e.destination]!=true){
                dfs(graph, e.destination, visited);
            }

        }
    }

    public static void main(String[] args){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean visited[] = new boolean[V];
        System.out.println("Expected : 0 1 2 3 4 5 6");
        System.out.print("Actual   : ");

        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                dfs(graph, i, visited);
            }
        }

    }
}
