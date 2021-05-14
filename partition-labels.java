class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); ++i)
            lastIndex[S.charAt(i) - 'a'] = i;
        
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList();
        
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndex[S.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return ans;
    }
}
