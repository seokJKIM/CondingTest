import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        
        boolean check = true;
        
        for(int i=0; i<s.length(); i++){
            if(check){
                answer += s.substring(i,i+1).toUpperCase();
                check = false;
            } else{
                    answer += s.substring(i,i+1);
            }
            
            if(s.substring(i,i+1).equals(" ")){
                check = true;
            }
        }
        return answer;
    }
}