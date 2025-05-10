package Graph_Matrix;

/**
 * Data Structures & Algorithms Category:
 * 👉 This problem belongs to **Graph Theory** and **Topological Sorting**.
 * Specifically, it deals with **Cycle Detection in a Directed Graph**.
 *
 * -----------------------------------------------------------------------------
 * Problem Statement:
 *
 * LeetCode 207: Course Schedule
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * Some courses may have prerequisites, given as an array prerequisites where prerequisites[i] = [a, b]
 * means you must take course b before course a.
 *
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * -----------------------------------------------------------------------------
 * Examples:
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: You can take course 0 first, then course 1.
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There is a cycle (0->1->0), making it impossible to finish all courses.
 *
 * -----------------------------------------------------------------------------
 * Brute Force Approach:
 * - Try all possible orders of courses (permutations) and check if they satisfy prerequisites.
 * - Time Complexity: O(N!), exponential — impractical for large number of courses.
 *
 * -----------------------------------------------------------------------------
 * Optimum Approach:
 * - Model the courses and prerequisites as a **directed graph**.
 * - Use **Topological Sorting** to determine if there's a valid course order.
 * - If a **cycle exists**, it's impossible to finish all courses.
 *   Otherwise, a valid ordering exists.
 * - Can be solved by:
 *      1. **BFS with Indegree Array (Kahn's Algorithm)**
 *      2. **DFS with Cycle Detection (visited/visiting flags)**
 * - Time Complexity: O(V + E), where V = number of courses, E = number of prerequisites.
 *
 * -----------------------------------------------------------------------------
 * Additional Hints:
 * - Think of courses as **nodes** and prerequisites as **directed edges**.
 * - Every node must be visited **exactly once** without revisiting in the same traversal (no cycles).
 * - Topological sorting is possible only in **DAG (Directed Acyclic Graph)**.
 */

public class LeetCode207_CourseSchedule_Medium_______PENDING {

    /**
     * Method to determine if all courses can be finished.
     *
     * @param numCourses      total number of courses
     * @param prerequisites   array of prerequisite pairs
     * @return                true if possible to finish all courses, false otherwise
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // TODO: Implement optimal solution here (DFS or BFS approach)
        return false; // placeholder return
    }

    // === Helper methods used in the implementation ===

    /**
     * Builds an adjacency list representing the course graph.
     * Each course maps to the list of courses dependent on it.
     *
     * @param numCourses    total number of courses
     * @param prerequisites prerequisite pairs
     * @return              adjacency list graph
     */
    private java.util.List<java.util.List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        java.util.List<java.util.List<Integer>> graph = new java.util.ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new java.util.ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            int dest = prereq[0];
            int src = prereq[1];
            graph.get(src).add(dest);
        }
        return graph;
    }

    /**
     * Performs DFS from a given node to detect cycles.
     *
     * @param node     current course being visited
     * @param graph    adjacency list graph
     * @param visiting marks nodes in the current DFS path
     * @param visited  marks nodes that are already fully processed
     * @return         true if cycle detected, false otherwise
     */
    private boolean hasCycle(int node, java.util.List<java.util.List<Integer>> graph, boolean[] visiting, boolean[] visited) {
        if (visiting[node]) {
            return true; // cycle detected
        }
        if (visited[node]) {
            return false; // already processed, no cycle here
        }

        visiting[node] = true;
        for (int neighbor : graph.get(node)) {
            if (hasCycle(neighbor, graph, visiting, visited)) {
                return true;
            }
        }
        visiting[node] = false;
        visited[node] = true;
        return false;
    }

    /**
     * Main method for testing sample inputs.
     */
    public static void main(String[] args) {
        LeetCode207_CourseSchedule_Medium_______PENDING solution = new LeetCode207_CourseSchedule_Medium_______PENDING();

        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Example 1 (Expected: true): " + solution.canFinish(2, prerequisites1));

        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Example 2 (Expected: false): " + solution.canFinish(2, prerequisites2));

        int[][] prerequisites3 = {{0,1}, {1,2}, {2,3}, {3,4}};
        System.out.println("Example 3 (Expected: true): " + solution.canFinish(5, prerequisites3));

        int[][] prerequisites4 = {{1,0},{2,1},{3,2},{1,3}};
        System.out.println("Example 4 (Expected: false): " + solution.canFinish(4, prerequisites4));
    }
}
