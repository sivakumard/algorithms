package com.cisan.algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * directed graph Breath First Search
 */
public class BFS {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;

    public BFS(int n, int[][] edges) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            graph.add(new LinkedList<>());
        for (int[] edge : edges)
            graph.get(edge[0]).add(edge[1]);
        System.out.println("Graph : " + graph);
    }

    public void search(int start) {
        Queue<Integer> queue = new LinkedList<>();

        System.out.print("Breath first search traversal: ");

        queue.offer(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            List<Integer> adj = graph.get(node);
            System.out.print(node + " ");
            for (int x : adj)
                if (!visited[x])
                    queue.add(x);
        }

    }

    public static void main(String[] args) {
        BFS bfs = new BFS(4, new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}});
        bfs.search(2);
    }
}
