class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //Brute
         int n = nums.length;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(j - i + 1 >= 2 && sum % k == 0) return true;
            }
        }
        return false; 

        // int n = nums.length, presum = 0;
        // int[] arr = new int[n];
        // arr[0] = nums[0];
        // for(int i = 1; i < n; i++) {
        //     arr[i] = arr[i - 1] + nums[i];
        //     if(arr[i] % k == 0) return true;
        // }
        // return false;
    }
}