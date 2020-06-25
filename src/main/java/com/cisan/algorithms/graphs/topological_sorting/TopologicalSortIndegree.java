package com.cisan.algorithms.graphs.topological_sorting;

import com.cisan.algorithms.graphs.GraphUtil;

import java.util.*;

//DAG - DFS
public class TopologicalSortIndegree {
    int n = 6;
    int[][] edges = {
            {5, 2},
            {5, 0},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1}
    };

    List<List<Integer>> graph = GraphUtil.edgesToGraph(n, edges, true);
    int[] indegree = new int[n];

    void topologicalSort() {
        for (int u = 0; u < n; u++)
            for (int v : graph.get(u))
                indegree[v]++;

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int u = 0; u < n; u++)
            if (indegree[u] == 0)
                queue.offer(u);

        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            list.add(u);
            for (int v : graph.get(u))
                if (--indegree[v] == 0)
                    queue.offer(v);
            count++;
        }

        if (count != n) {
            System.out.println("Topological sorting not possible");
            return;
        }

        System.out.println("Topological order : " + list);
    }


    public static void main(String[] args) {
        new TopologicalSortIndegree().topologicalSort();
    }

}
