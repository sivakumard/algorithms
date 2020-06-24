package com.cisan.algorithms.graphs.cycle;

import com.cisan.algorithms.graphs.GraphUtil;

import java.util.Arrays;
import java.util.List;

public class UnionFind {
    int n = 3, noOfEdges = 3;
    int[][] edges = {
            {0, 1},
            {1, 2},
            {0, 2}
    };

    List<List<Integer>> graph = GraphUtil.edgesToGraph(n, edges, true);
    int[] parent = new int[n];
    int[] rank = new int[n];

    int find(int i) {
        while (parent[i] != i)
            i = parent[i] = parent[parent[i]];
        return parent[i];
    }

    void union(int x, int y) {
        if(rank[x] < rank[y])
        {
            parent[x] = parent[y];
            rank[y]+= rank[x];
        } else {
            parent[y] = parent[x];
            rank[x] += rank[y];
        }
    }

    private void hasCycle() {
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < noOfEdges; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (find(u) == find(v)) {
                System.out.println("Graph has cycle");
                return;
            }
            System.out.println(Arrays.toString(parent));
            union(u, v);
        }
        System.out.println("Graph has no cycle");
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        uf.hasCycle();
    }
}
