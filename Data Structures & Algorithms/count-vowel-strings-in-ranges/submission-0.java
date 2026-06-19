/* class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int count = 0;
            for(int j = left; j <= right; j++) {
                String temp = words[j];
                if(isVowel(temp.charAt(0)) && isVowel(temp.charAt(temp.length() - 1))) {
                    count++;
                } else continue;
                arr[i] = count;
            }
        }
        return arr;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
} */

 class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length, l = words.length;
        int[] pre = new int[l];
        int[] arr = new int[n];

        int presum = 0;
        for(int i = 0; i < l; i++) {
            String temp = words[i];
            if(isVowel(temp.charAt(0)) && isVowel(temp.charAt(temp.length() - 1))) presum += 1;
            else presum += 0;

            pre[i] = presum;
        }

        int count = 0;
        for(int j = 0; j < n; j++) {
            int left = queries[j][0];
            int right = queries[j][1];

            int ri = pre[right];
            int li = (left > 0) ? pre[left - 1] : 0;
            arr[j] = ri - li;
        }
        return arr;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
 }