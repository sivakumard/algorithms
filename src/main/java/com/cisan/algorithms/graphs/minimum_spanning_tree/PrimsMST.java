package com.cisan.algorithms.graphs.minimum_spanning_tree;

import com.cisan.algorithms.graphs.GraphUtil;

import java.util.*;

public class PrimsMST {

    int[][] G = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
    };

    int n = G.length;

    List<List<int[]>> graph = GraphUtil.matrixToGraphUndirectedWithWeight(G);


    private void mst() {
        List<int[]> result = new ArrayList<>();

        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        heap.offer(new int[]{0, graph.get(0).get(0)[0], graph.get(0).get(0)[1]});
        boolean[] visited = new boolean[n];

        /*while (!heap.isEmpty() && result.size() < n - 1) {
            int[] edge = heap.poll();
            result.add(edge);
            visited[edge[0]] = true;
            for (int[] nei : graph.get(edge[0]))
                if(!visited[nei[0]])
                    heap.add(new int[]{edge[0], nei[0], nei[1]});
        }*/

        System.out.println("MST: ");
        for (int[] edge : result)
            System.out.println(Arrays.toString(edge));
    }

    public static void main(String[] args) {
        new PrimsMST().mst();
    }
}
