package com.cisan.algorithms.graphs.cycle;


import java.util.ArrayList;
import java.util.List;

public class CycleUndirected {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    public CycleUndirected(int n, int[][] edges) {
        visited = new boolean[n];
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);
    }
    private void isCyclic(int n) {
        for(int u = 0; u < n; u++)
            if(!visited[u])
                if(dfs(u, -1))
                {
                    System.out.println("Has cycle");
                    return;
                }
        System.out.println("No cycle");
    }

    boolean dfs(int u, int parent){
        visited[u] = true;
        for(int v : graph.get(u)){
            //System.out.print(v + ":" + parent + " ");
            if(!visited[v]) {
                if (dfs(v, u))
                    return true;
            } else if(v != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CycleUndirected obj = new CycleUndirected(5,
                new int[][]{{1,0}, {0,2}, {2,1}, {0,3}, {3,4}});
        obj.isCyclic(5);

        CycleUndirected obj1 = new CycleUndirected(3,
                new int[][]{{0,1}, {1,2}});
        obj1.isCyclic(3);
    }


}
