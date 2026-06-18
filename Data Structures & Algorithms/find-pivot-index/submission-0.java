class Solution {
    public int pivotIndex(int[] nums) {
        //Brute
        /*int n = nums.length;
        for(int i = 0; i < n; i++) {
            int lsum = 0;
            for(int j = 0; j < i; j++) {
                lsum += nums[j];
            }

            int rsum = 0;
            for(int j = i + 1; j < n; j++) {
                rsum += nums[j];
            }
                
            if(lsum == rsum) return i;
        }
        return -1; */

        int n = nums.length, totalSum = 0, lsum = 0;
        for(int i = 0; i < n; i++) totalSum += nums[i];

        for(int i = 0; i < n; i++) {
            int rsum = totalSum - nums[i] - lsum;
            if(lsum == rsum) return i;
            lsum += nums[i];
        }
        return -1;
    }
}