class Solution {
    public int subarraySum(int[] nums, int k) {
        // Optimal solution: https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap
        
        int count = 0;
        
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k)
                    count++;
            }
        }
        
        return count;
    }
}
