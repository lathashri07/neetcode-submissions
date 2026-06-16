class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //Brute
        /*int minlen = Integer.MAX_VALUE, n = nums.length;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(sum >= target) minlen = Math.min(minlen, j - i + 1);
            }
        }
        if(minlen == Integer.MAX_VALUE) return 0;
        else return minlen; */

        int l = 0, r = 0, sum = 0, minlen = Integer.MAX_VALUE, n = nums.length;
        while(r < n) {
            sum += nums[r];
            while(sum >= target) {
                minlen = Math.min(minlen, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        if(minlen == Integer.MAX_VALUE) return 0;
        else return minlen;
    }
}