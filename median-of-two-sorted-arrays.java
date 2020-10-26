class Solution {
    public double findMedianSortedArrays(int input1[], int input2[]) {     
    int m = input1.length;
    int n = input2.length;
        
    if (m > n) 
        return findMedianSortedArrays(input2, input1);    

    int start = 0;
    int end = m;
        
    while (start <= end) {
        
        int partitionX = start + (end - start)/2;
        int partitionY = (m + n + 1)/2 - partitionX;

        
        //Edge cases: adding Integer.MIN_VALUE and Integer.MAX_VALUE on either side of the boundaries
        int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
        int minRightX = (partitionX == m) ? Integer.MAX_VALUE : input1[partitionX];

        int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
        int minRightY = (partitionY == n) ? Integer.MAX_VALUE : input2[partitionY];

        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {   
            if ((m + n) % 2 == 0) 
                return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
            else 
                return (double)Math.max(maxLeftX, maxLeftY);     
        } 
        
        else if (maxLeftX > minRightY)   // Go on left side.
            end = partitionX - 1;
        else                             // Go on right side.
            start = partitionX + 1;
    }     
        
    return -1;
    }
}