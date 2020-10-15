class Solution {
    public int trap(int[] input) {
        int max = 0;
        
        int i = 0;
        int j = input.length - 1;        
        int leftmax = 0;
        int rightmax = 0;
        
        while(i <= j){
            leftmax = Math.max(leftmax, input[i]);
            rightmax = Math.max(rightmax, input[j]);
            
            if(leftmax < rightmax){
                max += leftmax - input[i];
                i++;
            }
            else{
                max+= rightmax - input[j];
                j--;
            }
        }
        
        return max;
    }
}