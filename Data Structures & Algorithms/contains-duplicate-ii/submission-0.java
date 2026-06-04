class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        //Brute
        /*if(n == 0) return false;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j <= n - 1; j++) {
                if(nums[i] == nums[j] && Math.abs(i - j) <= k) return true;
            }
        }
        return false; */

        //Sliding Window(Better)
        for(int l = 0; l < n; l++) {
            int r = l + 1;
            while(r < n) {
                if(nums[l] == nums[r] && Math.abs(l - r) <= k) return true;
                r++;
            }
        }
        return false;
    }
}