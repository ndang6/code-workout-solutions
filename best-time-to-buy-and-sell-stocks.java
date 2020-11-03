class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        
        int maxSoFar = 0;
        int smallest = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] <= smallest)
                smallest = prices[i];
            else
                maxSoFar = Math.max(maxSoFar, prices[i] - smallest);
        }
        
        return maxSoFar;
    }
}