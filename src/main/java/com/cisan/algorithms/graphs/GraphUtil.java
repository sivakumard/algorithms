package com.cisan.algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GraphUtil {

    public static List<List<Integer>> edgesToGraph(int n, int[][] edges, boolean isDirected) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new LinkedList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            if (!isDirected) graph.get(edge[1]).add(edge[0]);

        }
        System.out.println("Graph");
        for (int i = 0; i < n; i++)
            System.out.println(i + " -> " + graph.get(i));

        return graph;
    }

    public static List<List<Integer>> matrixToGraphUndirected(int[][] graphMatrix) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < graphMatrix.length; i++)
            graph.add(new LinkedList<>());
        System.out.println("Matrix");

        for (int[] col : graphMatrix)
            System.out.println(Arrays.toString(col));

        for (int i = 0; i < graphMatrix.length; i++)
            for (int j = 0; j < graphMatrix.length; j++)
                if (graphMatrix[i][j] == 1)
                    graph.get(i).add(j);


        System.out.println("Graph");
        for (int i = 0; i < graph.size(); i++)
            System.out.println(i + " -> " + graph.get(i));
        return graph;
    }
}
