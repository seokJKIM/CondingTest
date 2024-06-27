import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int idx = 1;
        int count = 0;
        
        String st = Integer.toBinaryString(n);
        
        for(int i=0; i<st.length(); i++){
            if(st.charAt(i)=='1') count++;    
        }
        
        while(true){
            int tmp = n+idx;
            int one = 0;
            String tmpString = Integer.toBinaryString(tmp);
            
            for(int i=0; i<tmpString.length(); i++){
                if(tmpString.charAt(i)=='1') one++;    
            }
            
            if(one == count) {
                answer = tmp;
                break;
            }
            idx++;
        }
        
        return answer;
    }
}