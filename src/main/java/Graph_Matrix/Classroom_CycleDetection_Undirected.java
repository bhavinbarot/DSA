package Graph_Matrix;

import java.util.ArrayList;

public class Classroom_CycleDetection_Undirected {
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
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));

    }


    public static boolean isCycleDetectedUndirected(ArrayList<Edge> graph[], boolean visited[], int current, int parent){
        visited[current] = true;
        //System.out.println("Parent - " + parent + " Current - " + current);
        for(int i=0;i<graph[current].size();i++){
            Edge e = graph[current].get(i);
            //System.out.println(" About next Node -> " + e.destination);
            if(visited[e.destination]){  //If destination has been visited
                if(e.destination!=parent){  //and destination is not parent
                    //System.out.println("$$$$Found Cycle...... ");
                    return true; //Found the cycle
                }else{ //and destination is not parent
                    //System.out.println(" --> Node has been visited already. Skip it");
                }
            }else{ //If destination has not been visited yet,
                //System.out.println(">>>It's unvisited. Let's go there. ");
                if(isCycleDetectedUndirected(graph, visited, e.destination, current)){
                    return true;
                }
                // visited[e.destination] = false;  //Backtracking not needed here.
            }
        }
        return false;
    }


    public static void main(String[] args){
        int V = 6;

        boolean visited[] = new boolean[V];

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int parent = -1;
        boolean cycleDetected = false;
        for(int i=0;i<V;i++){
            if(!visited[i]){ //if not visited
                cycleDetected = isCycleDetectedUndirected(graph, visited,i,parent);
                if(cycleDetected){
                    break;
                }

            }
        }

        System.out.println("cycleDetected? " + cycleDetected);

    }
}
