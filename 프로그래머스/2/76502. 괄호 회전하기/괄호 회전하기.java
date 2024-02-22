import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            Stack<Character> stack = new Stack<>();
            
            s = s.substring(1,s.length())+s.substring(0,1);
            
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                
                if(stack.isEmpty() || c=='[' || c=='(' ||c=='{'){
                    stack.push(c);
                }else if(c == ']'){
                    if(stack.peek() == '[') stack.pop();
                    else break;
                }else if(c == ')'){
                    if(stack.peek() == '(') stack.pop();
                    else break;
                }else if(c == '}'){
                    if(stack.peek() == '{') stack.pop();
                    else break;
                }
            }
            if(stack.isEmpty()) answer++;
            
        }
        return answer;
    }
}