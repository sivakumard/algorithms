package com.cisan.algorithms.graphs.topological_sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlienDictionary {
    String words[] = {"baa", "abcd", "abca", "cab", "cad"};
    int n = words.length;
    List<List<Character>> graph = new ArrayList<>();

    private void printOrder() {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            for (Character c : words[i].toCharArray())
                set.add(c);
        //for(Character )
    }

    public static void main(String[] args) {
        new AlienDictionary().printOrder();
    }


}
