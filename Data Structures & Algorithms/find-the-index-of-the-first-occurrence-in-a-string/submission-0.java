class Solution {
    public int strStr(String haystack, String needle) {
        //Brute
        /* int h = haystack.length(), n = needle.length();
        if(n == 0) return 0;

        for(int i = 0; i <= h - n; i++) {
            int j = 0;
            while(j < n && haystack.charAt(i + j) == needle.charAt(j)) j++;
            if(j == n) return i;
        }
        return -1; */

        //KMP
        int h = haystack.length(), n = needle.length();
        if(n == 0) return 0;
        int[] lps = buildLPS(needle);
        int i = 0, j = 0;

        while(i < h) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if(j == n)  return i - j;
            } else {
                if(j != 0) j = lps[j - 1];
                else  i++;
            }
        }
        return -1;
    }

    private int[] buildLPS(String needle) {
        int n = needle.length();
        int[] lps = new int[n];
        int i = 1, j = 0;
        
        while(i < n) {
            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if(j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;

    }
}