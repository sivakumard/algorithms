package com.cisan.algorithms.string.pattern_matching;

import java.util.Arrays;

/**
 * KMP algorithm for Pattern Searching:
 * <p>
 * Given a text txt[0..n-1] and a pattern pat[0..m-1],
 * write a function search(char pat[], char txt[])
 * that prints all occurrences of pat[] in txt[].
 * You may assume that n > m.
 */
public class KMPPatternMatching {

    void search(String txt, String pat) {
        int i = 0, j = 0, m = txt.length(), n = pat.length();
        int[] lps = new int[n];
        buildLPS(pat, lps);
        System.out.println(Arrays.toString(lps));
        while (i < m) {
            if (j == n-1) {
                System.out.println("Found pattern at index : " + (i - j));
                j = lps[j - 1];
            }
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) i++;
            else j = lps[j - 1];
        }
    }

    private void buildLPS(String pat, int[] lps) {
        int n = pat.length(), i = 0, j = 1;
        lps[0] = 0;
        while (j < n)
            if (pat.charAt(j) == pat.charAt(i))
                lps[j++] = ++i;
            else if (i == 0)
                lps[j++] = 0;
            else //if (i != 0) do not increment j
                i = lps[i - 1];
    }

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMPPatternMatching().search(txt, pat);
    }
}
