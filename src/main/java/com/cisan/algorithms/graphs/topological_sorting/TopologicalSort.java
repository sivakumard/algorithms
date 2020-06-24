package com.cisan.algorithms.graphs.topological_sorting;

import com.cisan.algorithms.graphs.GraphUtil;

import java.util.List;
import java.util.Stack;

//DAG - DFS
public class TopologicalSort {
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
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[n];
    void topologicalSort(){
        for(int i = 0; i < n; i++){
            if(!visited[i])
                dfs(i);
        }
        System.out.println("Topological sorting order: ");
        while (!stack.isEmpty())
            System.out.print(stack.pop()  + " ");
    }

    private void dfs(int u) {
        if(visited[u]) return;
        visited[u] = true;
        for(int v : graph.get(u))
            if(!visited[v])
                dfs(v);
        stack.push(u);
    }

    public static void main(String[] args) {
        new TopologicalSort().topologicalSort();
    }

}
