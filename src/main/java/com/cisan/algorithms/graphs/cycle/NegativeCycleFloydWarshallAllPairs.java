package com.cisan.algorithms.graphs.cycle;

import java.util.Arrays;

public class NegativeCycleFloydWarshallAllPairs {
    static int INF = 9999;
    int n = 4;
    int graph[][] = {{0, 1, INF, INF},
            {INF, 0, -1, INF},
            {INF, INF, 0, -1},
            {-1, INF, INF, 0}};

    int dist[][] = new int[n][n];

    private void shortestPath() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = graph[i][j];

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(dist[i]));

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (dist[i][j] < 0) {
                    System.out.println("Negative cycle found!");
                    return;
                }

        System.out.println("No negative cycle found!");
    }

    public static void main(String[] args) {
        NegativeCycleFloydWarshallAllPairs obj = new NegativeCycleFloydWarshallAllPairs();
        obj.shortestPath();
    }

}
