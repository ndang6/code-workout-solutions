class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                char s1FirstCharacter = s1.charAt(s1SpaceIndex+1);
                char s2FirstCharacter = s2.charAt(s2SpaceIndex+1);
                
                if (s1FirstCharacter <= '9') {
                    if (s2FirstCharacter <= '9') 
                        return 0; // both are digit-logs. Stay the same
                    else 
                        return 1; // s1 is digit-log, s2 is letter-log. Letter log comes first
                }
                if (s2FirstCharacter <= '9') 
                    return -1;    // s2 stays after if digit-log no matter what s1 is
                
                
                // compare "let2 own kid dig" with "let3 art zero"
                // compare "let3 art zero" with "let1 art zero"
                int preCompute = s1.substring(s1SpaceIndex+1).compareTo(s2.substring(s2SpaceIndex+1));
                if (preCompute == 0) 
                    return s1.substring(0,s1SpaceIndex).compareTo(s2.substring(0,s2SpaceIndex));
                
                return preCompute;
            }
        };
        
        Arrays.sort(logs, myComp);
        return logs;
    }
}
