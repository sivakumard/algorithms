package com.cisan.algorithms.string.pattern_matching;

/**
 * Naive algorithm for Pattern Searching:
 *
 * Given a text txt[0..n-1] and a pattern pat[0..m-1],
 * write a function search(char pat[], char txt[])
 * that prints all occurrences of pat[] in txt[].
 * You may assume that n > m.
 */
public class BruteForcePatternMatching {

    static void search(String txt, String pat){
        int i = 0, j = 0, m = txt.length(), n = pat.length();

        while(i < m){
            if(txt.charAt(i++) == pat.charAt(j)) {
                j++;
                while (i < m && j < n && txt.charAt(i++) == pat.charAt(j++)) {}
                if (j == n)
                    System.out.println("Pattern found at index : " + (i - n));
                j = 0;
            }
        }
    }

    public static void main(String[] args)
    {
        String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        search(txt, pat);
    }
}
