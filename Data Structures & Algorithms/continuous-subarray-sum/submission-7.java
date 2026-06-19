class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //Brute
        /* int n = nums.length;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(j - i + 1 >= 2 && sum % k == 0) return true;
            }
        }
        return false; */

        int n = nums.length, presum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        for(int i = 0; i < n; i++) {
            presum += nums[i];
            int rem = presum % k;
            if(mp.containsKey(rem)) {
                if(i - mp.get(rem) >= 2) return true;
            } else {
                mp.put(rem, i);
            }
        }
        return false;
    }
}