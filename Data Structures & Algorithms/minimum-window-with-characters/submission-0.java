class Solution {
    public String minWindow(String s, String t) {
        //Brute
        /*int n1 = s.length(), n2 = t.length();
        int minlen = Integer.MAX_VALUE, minIndex = -1; 
        if(n2 > n1) return "";

        for(int i = 0; i < n1; i++) {
            int[] map = new int[256];
            int k = 0;
            for(int j = 0; j < n2; j++) {
                map[t.charAt(j)]++;
            }
            for(int j = i; j < n1; j++) {
                if(map[s.charAt(j)] > 0) k++;
                map[s.charAt(j)]--;
                if(k == n2) {
                    if(j - i + 1 < minlen) {
                        minlen = j - i + 1;
                        minIndex = i;
                        break;
                    }
                }
            }
        } 
        s = s.substring(minIndex); 
        return s.substring(0, minlen); */

        int n1 = s.length(), n2 = t.length();
        int minlen = Integer.MAX_VALUE, minIndex = -1, l = 0, r = 0, k = 0; 
        if(n2 > n1) return "";

        int[] map = new int[256];
        for(char c : t.toCharArray()) {
            map[c]++;
        }

        while(r < n1) {
            if(map[s.charAt(r)] > 0) k++;
            map[s.charAt(r)]--;
            while(k == n2) {
                if(r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    minIndex = l;
                }
                map[s.charAt(l)]++;
                if(map[s.charAt(l)] > 0) k--;
                l++;
            }
            r++;
        }
        if(minIndex == -1) return "";
        else {
            s = s.substring(minIndex); 
            return s.substring(0, minlen);
        }
    }
}
