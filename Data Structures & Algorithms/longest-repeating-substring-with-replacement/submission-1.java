class Solution {
    public int characterReplacement(String s, int k) {
        //Brute
        /*int n = s.length();
        int maxlen = 0;
        for(int i = 0; i < n; i++) {
            int[] arr = new int[26];
            int maxfeq = 0;
            for(int j = i; j < n; j++) {
                arr[s.charAt(j) - 'A']++;
                maxfeq = Math.max(maxfeq, arr[s.charAt(j) - 'A']);
                int rep = (j - i + 1) - maxfeq;
                if(rep <= k) {
                    maxlen = Math.max(maxlen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxlen; */

        int[] map = new int[26];
        int n = s.length();
        int maxlen = 0, maxfreq = 0, l = 0;
        for(int r = 0; r < n; r++) {
            map[s.charAt(r) - 'A']++;
            maxfreq = Math.max(maxfreq, map[s.charAt(r) - 'A']);
            if((r - l + 1) - maxfreq > k) {
                map[s.charAt(l) - 'A']--;
                maxfreq = 0;
                for(int i = 0; i < 25; i++) {
                    maxfreq = Math.max(maxfreq, map[i]);
                }
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
        }
        return maxlen;
    }
}
