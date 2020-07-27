package com.cisan.data_structure.array.suffix_array;

public class EquilibriumIndex {

    public static void main(String[] args)
    {
        EquilibriumIndex equilibriumIndex = new EquilibriumIndex();
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(equilibriumIndex.equilibrium(arr));
    }

    private int equilibrium(int[] arr) {
        int sum = 0;

        for(int i = 0; i < arr.length; i++)
            sum+=arr[i];

        int leftSum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum -= arr[i];
            if(leftSum == sum) return i;
            leftSum+=arr[i];
        }
        return  -1;
    }
}
