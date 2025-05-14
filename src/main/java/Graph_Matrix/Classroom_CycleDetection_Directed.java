package Graph_Matrix;

import java.util.ArrayList;

public class Classroom_CycleDetection_Directed {
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
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));

    }


    public static boolean isCycleDetected(ArrayList<Edge> graph[], boolean visited[], int current, boolean recursionStack[]){
        visited[current] = true;
        recursionStack[current] = true;

        for(int i=0;i<graph[current].size();i++){
            Edge e = graph[current].get(i);
            if(recursionStack[e.destination]){ //If Destination is already a part of recursion stack (it is part of the cycle)
                return true;
            }else if(!visited[e.destination]){ //If it has not been visited yet, visit the next part
                return isCycleDetected(graph, visited, e.destination, recursionStack);
            }
        }
        recursionStack[current] = false; //Make Recursion false (Backtracking)
        return false;
    }


    public static void main(String[] args){
        int V = 4;

        boolean visited[] = new boolean[V];
        boolean recursionStack[] = new boolean[V];
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        for(int i=0;i<V;i++){
            if(!visited[i]){ //if not visited
                boolean cycleDetected = isCycleDetected(graph, visited,i,recursionStack);
                if(cycleDetected){
                    System.out.println(cycleDetected);
                    break;
                }

            }
        }


    }
}
