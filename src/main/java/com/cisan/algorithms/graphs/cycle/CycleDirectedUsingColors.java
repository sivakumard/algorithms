package com.cisan.algorithms.graphs.cycle;

import java.util.ArrayList;
import java.util.List;

public class CycleDirectedUsingColors {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    static int WHITE = 0, GRAY = 1, BLACK = 2;
    int[] color;

    public CycleDirectedUsingColors(int n, int[][] edges) {
        color = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        System.out.println(graph);
    }

    void hasCycle(int n) {
        for (int i = 0; i < n; i++) {
            if(color[i] == WHITE)
                if (dfs(i)) {
                    System.out.println("Has cycle");
                    return;
                }
            System.out.println();
        }
        System.out.println("No cycle");
    }

    private boolean dfs(int u) {
        if (color[u] == GRAY) return true;
        if (visited[u]) return false;
        visited[u] = true;
        color[u] = GRAY;
        for (int v : graph.get(u))
            if (dfs(v))
                return true;
        color[u] = BLACK;
        return false;
    }

    public static void main(String[] args) {
        CycleDirectedUsingColors obj = new CycleDirectedUsingColors(4,
                new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}});
        obj.hasCycle(4);
    }
}
