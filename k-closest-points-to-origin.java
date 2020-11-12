class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int len =  points.length, m = 0, n = len - 1;
        
        while (m < n) {
            int mid = helper(points, m, n);
            
            if (mid == K) 
                break;
            if (mid < K) 
                m = mid + 1;
            else 
                n = mid - 1;
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int m, int n) {
        // chose a "random" pivot
        int[] pivot = A[m];
        
        while (m < n) {
            // A[n] is greater than the pivot
            while (m < n && compare(A[n], pivot) >= 0) 
                n--;
            A[m] = A[n]; // swap
            
            // A[m] is smaller than the pivot
            while (m < n && compare(A[m], pivot) <= 0) 
                m++;
            A[n] = A[m];
        }
        A[m] = pivot;
        return m;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}