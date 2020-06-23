package com.cisan.algorithms.graphs.shortest_path;

import java.util.*;

public class DijkstraShortestPath {
    List<List<int[]>> graph = new ArrayList<>();
    Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    int n;
    int[] dist;
    boolean[] visited;

    public DijkstraShortestPath(int n, int[][] edges)  {
        this.n = n;
        dist = new int[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge:edges){
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }
    }

    void shortestPath(){
        for(int i = 1; i < n; i++)
            dist[i] = Integer.MAX_VALUE;

        heap.offer(new int[]{0,0});
        while (!heap.isEmpty()){
            int[] arr = heap.poll();
            int u = arr[0];
            visited[u] = true;
            for(int[] nei : graph.get(u)){
                int v = nei[0];
                int cost = nei[1];
                if(!visited[v]) {
                    if (dist[u] + cost < dist[v]) {
                        dist[v] = dist[u] + cost;
                    }
                    heap.offer(nei);
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        DijkstraShortestPath obj = new DijkstraShortestPath(9,
                new int[][]{
                        {0,1,4},
                        {0,7,8},
                        {1,2,8},
                        {1,7,11},
                        {2,3,7},
                        {2,8,2},
                        {2,5,4},
                        {3,4,9},
                        {3,5,14},
                        {4,5,10},
                        {5,6,2},
                        {6,7,1},
                        {6,8,6},
                        {7,8,7}
                }
        );
        obj.shortestPath();
    }
}
