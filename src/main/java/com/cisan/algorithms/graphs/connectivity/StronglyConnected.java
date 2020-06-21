package com.cisan.algorithms.graphs.connectivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a directed graph, find out whether the graph is strongly connected or not.
 * A directed graph is strongly connected if there is a path between any two pair
 * of vertices. For example, following is a strongly connected graph.
 * (Kosaraju using DFS)
 */

public class StronglyConnected {
    List<List<Integer>> graph = new ArrayList<>();
    List<List<Integer>> rGraph = new ArrayList<>();

    boolean[] visited;

    public StronglyConnected(int n, int[][] edges) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            graph.add(new LinkedList<>());
        for (int[] edge : edges)
            graph.get(edge[0]).add(edge[1]);
        System.out.println("Graph :" + graph);
    }

    private void isStronglyConnected(int n) {
        visited = new boolean[n];
        dfs(0, graph);
        if (!allVisited(n))
            return;
        //reverse the graph and do dfs
        transpose(n);
        visited = new boolean[n];
        dfs(0, rGraph);
        if (allVisited(n))
            System.out.println("Graph is strongly connected");
    }

    private boolean allVisited(int n) {
        for (int i = 0; i < n; i++)
            if (!visited[i]) {
                System.out.println("Graph is not strongly connected");
                return false;
            }
        return true;
    }

    private void transpose(int n) {
        rGraph = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            rGraph.add(new LinkedList<>());

        for (int i = 0; i < n; i++)
            for (int v : graph.get(i))
                rGraph.get(v).add(i);
        System.out.println("Reverse graph: "+ rGraph);
    }

    private void dfs(int u, List<List<Integer>> graph) {
        if (visited[u]) return;
        visited[u] = true;
        for (int v : graph.get(u))
            if (!visited[v])
                dfs(v, graph);
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        int n = 4;
        StronglyConnected obj = new StronglyConnected(n,
                new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}});
        obj.isStronglyConnected(n);
        System.out.println("---------------------------------------");
        int n1 = 5;
        StronglyConnected obj1 = new StronglyConnected(n1,
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}, {2, 4}, {4, 2}});
        obj1.isStronglyConnected(n1);
        System.out.println("---------------------------------------");
        StronglyConnected obj2 = new StronglyConnected(n,
                new int[][]{{0, 1}, {1, 2}, {2, 3}});
        obj2.isStronglyConnected(n);
        System.out.println("---------------------------------------");
    }


}
