package com.cisan.algorithms.graphs.shortest_path;

import java.util.Arrays;

public class FloydWarshallAllPairs {
    static int INF = 999;
    int n = 4;
    int graph[][] = { {0,   5,  INF, 10},
            {INF, 0,   3, INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
    };

    int dist[][] = new int[n][n];

    private void shortestPath() {
        for(int i =0; i < n; i++)
            for(int j = 0; j < n; j++)
                dist[i][j] = graph[i][j];

        for(int k = 0; k < n; k++)
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    if(dist[i][k] + dist[k][j]  < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        for(int i = 0; i < n ; i++)
            System.out.println(Arrays.toString(dist[i]));
    }

    public static void main(String[] args) {
        FloydWarshallAllPairs obj = new FloydWarshallAllPairs();
        obj.shortestPath();
    }

}
