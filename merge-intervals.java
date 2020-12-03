class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
			return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        
		List<int[]> list = new ArrayList<>();
        
		int[] pendingInterval = intervals[0];
		list.add(pendingInterval);
        
		for (int[] currentInterval : intervals) {       
            
			if (pendingInterval[1] >= currentInterval[0])
				pendingInterval[1] = Math.max(pendingInterval[1], currentInterval[1]);
            
			else {                             
				pendingInterval = currentInterval;
				list.add(pendingInterval);
			}
		}
        
        int size = list.size();
		return list.toArray(new int[size][]);
    }
}