class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Brute
        /*int maxlen = 0;
        for(int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j = i; j < s.length(); j++) {
                if(set.contains(s.charAt(j))) break;
                int len = j - i + 1;
                maxlen = Math.max(maxlen, len);
                set.add(s.charAt(j));
            }
        }
        return maxlen; */

        //Optimize
        /* HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int maxlen = 0, l = 0;
        for(int r = 0; r < n; r++) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            int len = r - l + 1;
            maxlen = Math.max(maxlen, len);
            set.add(s.charAt(r));
        }
        return maxlen; */

        //Better
        int[] hash = new int[256];
        int n = s.length();
        int maxlen = 0, l = 0;
        Arrays.fill(hash, -1);
        for(int r = 0; r < n; r++) {
            if(hash[s.charAt(r)] != -1) {
                if(hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }
            maxlen = Math.max(maxlen, r - l + 1);
            hash[s.charAt(r)] = r;
        }
        return maxlen;
    }
}
