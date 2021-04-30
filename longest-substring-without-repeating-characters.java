class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();        

        for (int i = 0, j = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1); // in case "abba", prevents going backwards
            }
            map.put(s.charAt(i), i);

            max = Math.max(max, i-j+1);
        }

        return max;
    }
}
