package com.cisan.algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * directed graph Depth First Search
 */
public class DFS {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;

    public DFS(int n, int[][] edges) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            graph.add(new LinkedList<>());
        for (int[] edge : edges)
            graph.get(edge[0]).add(edge[1]);
        System.out.println("Graph : " + graph);
    }

    public void dfs(int node) {
        if(visited[node]) return;
        visited[node] = true;
        System.out.print(node + " ");
        for (int x : graph.get(node))
            if (!visited[x])
                dfs(x);

    }

    public static void main(String[] args) {
        int n =4;
        DFS obj = new DFS(n, new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}});
        System.out.print("Depth first search traversal: ");

        for(int i = 0; i < n; i++)
            obj.dfs(i);
    }
}
