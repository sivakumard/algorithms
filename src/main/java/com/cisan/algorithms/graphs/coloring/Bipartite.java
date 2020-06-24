package com.cisan.algorithms.graphs.coloring;

import com.cisan.algorithms.graphs.GraphUtil;

import java.util.List;

public class Bipartite {
    int G[][] = {{0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}};
    static int RED = 0, BLUE = 1;
    List<List<Integer>> graph = GraphUtil.matrixToGraphUndirected(G);
    Integer[] color = new Integer[graph.size()];

    private void isBipartite() {
        for (int i = 0; i < graph.size(); i++)
            if (color[i] == null && !dfs(i, RED)) {
                System.out.println("Not Bipartite graph");
                return;
            }
        System.out.println("It is Bipartite graph");
    }

    private boolean dfs(int u, int c) {
        if (color[u] != null) return color[u] == c;
        color[u] = c;
        for (int v : graph.get(u))
            if (!dfs(v, c ^ 1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Bipartite obj = new Bipartite();
        obj.isBipartite();
    }
}
