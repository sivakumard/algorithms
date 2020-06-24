package com.cisan.algorithms.graphs.shortest_path;


import java.util.*;

public class BellmenFordShortestPath {
    int n;
    int[] dist;
    int[][] edges;

    public BellmenFordShortestPath(int n, int[][] edges)  {
        this.n = n;
        dist = new int[edges.length];
        this.edges = edges;
    }

    void shortestPath(){
        for(int i = 1; i < edges.length; i++)
            dist[i] = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++)
            for (int j = 0; j < edges.length; j++){
                int u = edges[j][0], v = edges[j][1], w = edges[j][2];
                System.out.println(Arrays.toString(edges[j]) + ":" + j + ":");
                System.out.println(Arrays.toString(dist));
                if(dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }

        System.out.println(Arrays.toString(dist));

        for(int j = 0; j < edges.length; j++) {
            int u = edges[j][0], v = edges[j][1], w = edges[j][2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Has Negative cycles");
                return;
            }
        }
        System.out.println("No Negative cycles");

    }

    public static void main(String[] args) {
        BellmenFordShortestPath obj = new BellmenFordShortestPath(5,
                new int[][]{
                        {0,1,-1},
                        {0,2,4},
                        {1,2,3},
                        {1,3,2},
                        {1,4,2},
                        {3,2,5},
                        {3,1,1},
                        {4,3,-3}
                }
        );
        obj.shortestPath();
    }
}
