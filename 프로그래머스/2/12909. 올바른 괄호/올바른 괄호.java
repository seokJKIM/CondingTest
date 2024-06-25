import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> deque = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            
            if(deque.size() == 0){
                deque.addFirst(c);
                continue;
            }
            
            if(deque.peekFirst() == '(' && c == ')'){
                deque.pollFirst();
            }else{
                deque.addFirst(c);
            }
        }
        
        if(deque.size() != 0) answer = false;
        
        return answer;
    }
}