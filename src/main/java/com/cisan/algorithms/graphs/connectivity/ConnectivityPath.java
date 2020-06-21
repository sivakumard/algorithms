package com.cisan.algorithms.graphs.connectivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Find if there is a path between two vertices in a directed graph
 */

public class ConnectivityPath {
    List<List<Integer>> graph = new ArrayList<>();

    public ConnectivityPath(int n, int[][] edges) {

        for(int i = 0; i < n; i++)
            graph.add(new LinkedList<>());
        for(int[] edge : edges)
            graph.get(edge[0]).add(edge[1]);
        System.out.println(graph);
    }

    private void isPathExists(int n, int u, int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(u);
        visited[u] = true;

        while (!queue.isEmpty()){
            int node  = queue.poll();
            visited[node] = true;
            //System.out.print(node + " ");
            for(int x : graph.get(node)){
                if(x == v){
                    System.out.println("Path found between " + u +":" + v);
                    return;
                }
                if(!visited[x])
                    queue.offer(x);
            }
        }
        System.out.println("No path found between " + u +":" + v);
    }

    public static void main(String[] args) {
        int n = 4;
        ConnectivityPath obj = new ConnectivityPath(n, new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}});
        obj.isPathExists(n,1,3);
        obj.isPathExists(n,1,6);
    }


}
