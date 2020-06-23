package com.cisan.algorithms.graphs.cycle;

import java.util.ArrayList;
import java.util.List;

public class CycleDirected {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[]  visited;
    Boolean[] disc;

    public CycleDirected(int n, int[][] edges) {
        disc = new Boolean[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
        System.out.println(graph);
    }

    void hasCycle(int n){
        for(int i = 0; i < n; i++) {
            if (dfs(i)) {
                System.out.println("Has cycle");
                return;
            }
            System.out.println();
        }
        System.out.println("No cycle");
    }

    private boolean dfs(int u) {
        //System.out.print(u + ":" + disc[u] + " ");
        if(disc[u] != null && !disc[u]) return true;
        if(visited[u]) return false;
        visited[u] = true;
        disc[u] = false;
        for(int v : graph.get(u))
            if(dfs(v))
                return true;
        disc[u] = true;
        return false;
    }

    public static void main(String[] args) {
        CycleDirected obj = new CycleDirected(4,
                new int[][]{{0,1}, {0,2}, {1,2}, {2,0}, {2,3}, {3,3}});
        obj.hasCycle(4);
    }
}
