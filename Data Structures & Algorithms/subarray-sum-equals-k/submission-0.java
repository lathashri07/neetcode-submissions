class Solution {
    public int subarraySum(int[] nums, int k) {
        //Brute
        /* int n = nums.length, count = 0;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;               
                }
            }
        }
        return count; */

        int n = nums.length, count = 0, presum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            mp.put(presum, mp.getOrDefault(presum, 0) + 1);
            presum += nums[i];
            if(mp.containsKey(presum - k)) count += mp.get(presum - k);
        }
        return count;
    }
}