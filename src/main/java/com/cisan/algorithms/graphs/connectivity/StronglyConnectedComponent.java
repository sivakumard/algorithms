package com.cisan.algorithms.graphs.connectivity;

import java.util.*;

/**
 * A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph
 * (Kosaraju using DFS)
 */

public class StronglyConnectedComponent {
    List<List<Integer>> graph = new ArrayList<>();
    List<List<Integer>> rGraph = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    boolean[] visited;

    public StronglyConnectedComponent(int n, Integer[][] edges) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            graph.add(new LinkedList<>());
        for (Integer[] edge : edges)
            graph.get(edge[0]).add(edge[1]);
        System.out.println("Graph :" + graph);
    }

    private void scc(int n) {
        visited = new boolean[n];
        for (Integer i = 0; i < n; i++)
            dfs(i, graph, stack);
        //reverse the graph and do dfs
        transpose(n);
        visited = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < stack.size(); i++) {
            Integer node = stack.pop();
            if (!visited[node]) {
                List<Integer> list = new ArrayList<>();
                dfs(node, rGraph, list);
                result.add(list);
            }
        }
        System.out.println("SCC: " + result);
    }

    private void transpose(int n) {
        rGraph = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            rGraph.add(new LinkedList<>());

        for (Integer i = 0; i < n; i++)
            for (Integer v : graph.get(i))
                rGraph.get(v).add(i);
        System.out.println("Reverse graph: " + rGraph);
    }

    private void dfs(Integer u, List<List<Integer>> graph, List<Integer> list) {
        if (visited[u]) return;
        visited[u] = true;
        list.add(u);
        for (Integer v : graph.get(u))
            if (!visited[v])
                dfs(v, graph, list);
    }

    private void dfs(Integer u, List<List<Integer>> graph, Stack<Integer> stack) {
        if (visited[u]) return;
        visited[u] = true;
        for (int v : graph.get(u))
            if (!visited[v])
                dfs(v, graph, stack);
        stack.push(u);
    }

    public static void main(String[] args) {
        int n = 5;
        StronglyConnectedComponent obj = new StronglyConnectedComponent(n,
                new Integer[][]{{1, 0}, {0, 2}, {2, 1}, {0, 3}, {3, 4}});
        obj.scc(n);
    }


}
