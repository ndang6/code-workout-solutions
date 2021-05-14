class Solution {
    public void nextPermutation(int[] nums) {
      int n = nums.length - 1, p = -1, pv = 0;

      // step 1, be careful, i starts from n - 1
      for(int i = n - 1; i >= 0; i--){
        if(nums[i] < nums[i + 1]) {
            p = i;
            pv = nums[i];
            break;
        }
      }    
      
      if(p == -1) {
        reverse(nums, 0, n);
        return;
      }
      
      // step 2
      for(int i = n; i > p; i--){
        if(nums[i] > pv){
          swap(nums, p, i);
          break;
        }
      }
      
        
      // step 3: We need to sort, but because this is already the last permuation, we simply reverse it
      reverse(nums, p + 1, n);
    }
    
    private void reverse(int[] nums, int s, int e){
      while(s < e){
        swap(nums, s++, e--);
      }
    }
    
    private void swap(int[] nums, int s, int e){
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;     
    }
}
