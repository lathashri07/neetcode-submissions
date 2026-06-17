class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Brute
        /*int n1 = s1.length(), n2 =  s2.length();
        if(n1 > n2) return false;

        // Map<Character, Integer> mp1 = new HashMap<>();
        int[] freq1 = new int[26];
        for(char c1 : s1.toCharArray()) {
            // mp1.put(c1, mp1.getOrDefault(c1, 0) + 1);
            freq1[c1 - 'a']++;
        }

        for(int i = 0; i < n2; i++) {
            //  Map<Character, Integer> mp2 = new HashMap<>();
            int[] freq2 = new int[26];
            for(int j = i; j < n2; j++) {
                char c2 = s2.charAt(j);
                // mp2.put(c2, mp2.getOrDefault(c2, 0) + 1);
                freq2[c2 - 'a']++;
                if(j - i + 1 == n1) {
                    // if(mp1.equals(mp2)) return true;
                    if(Arrays.equals(freq1, freq2)) return true;
                    break;
                }
            }
        }
        return false; */

        int n1 = s1.length(), n2 =  s2.length(), l = 0, r = 0;
        if(n1 > n2) return false;

        int[] freq1 = new int[26];
        for(char c1 : s1.toCharArray()) {
            freq1[c1 - 'a']++;
        }

        int[] freq2 = new int[26];
        while(r < n2) {
            freq2[s2.charAt(r) - 'a']++;
            if(n1 == r - l + 1) {
                if(Arrays.equals(freq1, freq2)) return true;
                freq2[s2.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return false;
    }
}
