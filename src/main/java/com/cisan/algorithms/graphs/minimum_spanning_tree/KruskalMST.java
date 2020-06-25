package com.cisan.algorithms.graphs.minimum_spanning_tree;

import com.cisan.algorithms.graphs.GraphUtil;

import java.util.*;

public class KruskalMST {
    int n = 4, noOfEdges = 5;
    int[][] edges = {
            {0, 1, 10},
            {0, 2, 6},
            {0, 3, 5},
            {1, 3, 15},
            {2, 3, 4},
    };

    List<List<Integer>> graph = GraphUtil.edgesToGraph(n, edges, true);

    int[] parent = new int[n];
    int[] rank = new int[n];

    int find(int i) {
        while (parent[i] != i)
            i = parent[i] = parent[parent[i]];
        return i;
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rank[rootX] < rank[rootY])
            parent[rootX] = parent[rootY];
        else if (rank[rootX] > rank[rootY])
            parent[rootY] = parent[rootX];
        else {
            parent[rootY] = parent[rootX];
            rank[rootY]++;
        }
    }

    private void mst() {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int[] edge : edges)
            heap.offer(edge);

        while (!heap.isEmpty()) {
            int[] edge = heap.poll();
            int u = edge[0], v = edge[1], w = edge[2];

            if (find(u) != find(v)) {
                result.add(edge);
                union(u, v);
            }
        }
        System.out.println("MST: ");
        for(int[] edge : result)
            System.out.println(Arrays.toString(edge));
    }

    public static void main(String[] args) {
        new KruskalMST().mst();
    }
}
