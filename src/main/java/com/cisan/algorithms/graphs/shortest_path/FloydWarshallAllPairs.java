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


    private void shortestPath() {
        for(int k = 0; k < n; k++)
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    if(graph[i][k] + graph[k][j]  < graph[i][j])
                        graph[i][j] = graph[i][k] + graph[k][j];

        for(int i = 0; i < n ; i++)
            System.out.println(Arrays.toString(graph[i]));
    }

    public static void main(String[] args) {
        FloydWarshallAllPairs obj = new FloydWarshallAllPairs();
        obj.shortestPath();
    }

}
