class Solution {
    public int trap(int[] height) {
        int max = 0;
        
        int i = 0;
        int j = height.length - 1;        
        int leftmax = 0;
        int rightmax = 0;
        
        while(i <= j){
            leftmax = Math.max(leftmax, height[i]);
            rightmax = Math.max(rightmax, height[j]);
            
            if(leftmax < rightmax){
                max += leftmax - height[i];
                i++;
            }
            else{
                max+= rightmax - height[j];
                j--;
            }
        }
        
        return max;
    }
}