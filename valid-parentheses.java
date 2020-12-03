// s = {[()]}
// returns true
class Solution {
	public boolean isValid(String s){      
        Stack<Character> myStack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '(') myStack.push(')');
            
            else if(c == '[') myStack.push(']');
            
            else if(c == '{') myStack.push('}');
                
            else if(!myStack.isEmpty()){
                if(c == myStack.pop())
                    continue;
                else
                    return false;
            }
            else // empty stack
                return false;       
        }
        
        return myStack.isEmpty();
    }
}
