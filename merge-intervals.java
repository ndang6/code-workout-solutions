// intervals = [[1,4],[2,3],[15,18],[8,10]]
// returns [[1,4],[8,10],[15,18]]
class Solution {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> list = new ArrayList<>();
		int[] pendingInterval = intervals[0];
		list.add(pendingInterval);

		for (int[] interval : intervals) {
			if (pendingInterval[1] >= interval[0]) {
				pendingInterval[1] = Math.max(pendingInterval[1], interval[1]);
			} else {
				pendingInterval = interval;
				list.add(pendingInterval);
			}
		}

		int size = list.size();
		return list.toArray(new int[size][]);
	}
}
