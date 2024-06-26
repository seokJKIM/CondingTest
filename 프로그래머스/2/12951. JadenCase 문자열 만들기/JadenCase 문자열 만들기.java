import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        boolean check = true;
        s = s.toLowerCase();
        
        for(int i=0; i<s.length(); i++){
            
            String st = s.substring(i,i+1);
            
            if(st.equals(" ")){
                answer += " ";
                check = true; 
            }else{
               if(check){
                   answer += st.toUpperCase();
                   check = false;  
               } else{
                   answer += st;
               }
            }
        }       
        
        return answer;
    }
}