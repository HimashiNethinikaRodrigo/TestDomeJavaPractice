package main.edu.testdome.java.RoutePlanner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoutePlanner {
    // use breadth first search - can use for balanced arrays
    int v;
    List<List<Integer>> graph;
    RoutePlanner (int v)
    {
        this.v = v;
        graph = new ArrayList<>(v);
        for (int i=0; i<v; i++){
            graph.add(i, new ArrayList<>());
        }
    }
    void addEdge(int s, int d)
    {
        graph.get(s).add(d);
        graph.get(d).add(s);
    }
    static boolean isSafe(int i, int j, boolean[][] mapMatrix)
    {
        int n = mapMatrix.length;
        if ((i < 0 || i >= n) || (j < 0 || j >= n) || !mapMatrix[i][j])
            return false;
        return true;
    }

    boolean BFS(int s, int d)
    {
        if (s == d)
            return true;

        boolean[] visited = new boolean[v];

        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.offer(s);

        List<Integer> edges;

        while (!queue.isEmpty()) {
            s = queue.poll();
            edges = graph.get(s);
            for (int curr : edges) {
                if (curr == d)
                    return true;

                if (!visited[curr]) {
                    visited[curr] = true;
                    queue.offer(curr);
                }
            }
        }

        return false;
    }
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        int n = mapMatrix.length;
        int v = n*n +2;
        int s = -1, d = -1;
        RoutePlanner graph = new RoutePlanner(v);
        int k= 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j< n; j++) {
                if (mapMatrix[i][j]) {
                    if (isSafe(i, j+1, mapMatrix))
                        graph.addEdge(k, k+1);
                    if (isSafe(i, j - 1, mapMatrix))
                        graph.addEdge(k, k - 1);
                    if (j < n - 1 && isSafe(i + 1, j, mapMatrix))
                        graph.addEdge(k, k + n);
                    if (i > 0 && isSafe(i - 1, j, mapMatrix))
                        graph.addEdge(k, k - n);
                }

                if (i==fromRow && j== fromColumn)
                    s= k;

                if (i== toRow && j== toColumn)
                    d= k;

                k++;
            }
        }
        return graph.BFS(s, d);
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}
