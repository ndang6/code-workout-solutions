class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int len =  points.length, m = 0, n = len - 1;
        
        while (m < n) {
            int mid = partition(points, m, n);
            
            if (mid == K) break;
            else if (mid < K) m = mid + 1;
            else n = mid - 1;
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] A, int m, int n) {
        int[] pivot = A[m]; // chose a "random" pivot
        
        while (m < n) {
            
            while (m < n && compare(A[n], pivot) >= 0) 
                n--; // A[n] is greater than the pivot
            A[m] = A[n]; // otherwise, swap
                   
            while (m < n && compare(A[m], pivot) <= 0) 
                m++; 
            A[n] = A[m];
        }

        A[m] = pivot; // re-assign the value of the pivot to the location A[m]
        return m;     // returns the index of the pivot after partitioning
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}
