class Solution {
    public int consecutiveNumbersSum(int N) {
        int sum = 0, ans = 0;
        
        for(int i = 1; ; i++) {
            sum += i-1;
            
            if(sum >= N)
                break;
            
            if ( (N-sum) % i == 0)
                ans++;           
        }
        
        return ans;      
    }
}