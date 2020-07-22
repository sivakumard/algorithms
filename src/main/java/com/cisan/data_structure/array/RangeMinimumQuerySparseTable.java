package com.cisan.data_structure.array;

import java.util.Arrays;

public class RangeMinimumQuerySparseTable {
    Integer lookup[][];
    int k = 25;
    int n;
    int[] arr;

    public RangeMinimumQuerySparseTable(int[] arr) {
        n = arr.length;
        this.arr = arr;
        buildSparseTable();
    }

    private void buildSparseTable() {
        lookup = new Integer[n][k+1];
        for(int i = 0; i < n; i++)
            lookup[i][0] = arr[i];

        for(int j = 1; j < k; j++)
            for(int i = 0; i+(1<<j) < n; i++)
                lookup[i][j] = Math.min(lookup[i][j-1], lookup[i+(1 << (j-1))][j-1]);
        for (Integer[] a : lookup)
            System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int a[] = {7, 2, 3, 0, 5, 10, 3, 12, 18};
        RangeMinimumQuerySparseTable rangeMinimumQuerySparseTable = new RangeMinimumQuerySparseTable(a);

        rangeMinimumQuerySparseTable.query(0,4);
        rangeMinimumQuerySparseTable.query(4,7);
        rangeMinimumQuerySparseTable.query(7,8);
    }

    private void query(int l, int r) {
        int min = Integer.MAX_VALUE;
        System.out.print(l + ":" + r);
        for(int j = k; j >= 0; j--)
            if(l+(1<<j) <= r+1) {
                if(lookup[l][j] != null) {
                    min = Math.min(min, lookup[l][j]);
                    l += (1 << j);
                }
            }
        System.out.println("->" + min);

    }

}
