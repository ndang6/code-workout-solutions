// s = 3[a]2[bc]
// returns aaabcbc
class Solution {
	public String decodeString(String s){
		String res = "";
      
      Stack<Integer> countStack = new Stack<>();
      Stack<String> stringStack = new Stack<>();
      int index = 0;
      
      while(index < s.length()){
        /* Step 1: Count the digit */
        if(Character.isDigit(s.charAt(index))){
          int count = 0;
          while(Character.isDigit(s.charAt(index))){
            count = count * 10 + (s.charAt(index++) - '0');
          }
          countStack.push(count);
        }
        
        else if(s.charAt(index) == '['){
          stringStack.push(res); // save the current result
          res = "";              // reset to empty string
          index = index + 1;
        }
        
        else if(s.charAt(index) == ']'){
          StringBuilder temp = new StringBuilder(stringStack.pop()); // get the previous result string
          int repeatTimes = countStack.pop();
          
          for(int i = 0; i < repeatTimes; i++){
            temp.append(res); /* Step 3: appending */
          }
          
          res = temp.toString();
          index = index + 1;
        }
        
        /* Step 2: Count the characters */
        else{
          res += s.charAt(index++);
        }
      }
      
      return res;
	}
}
