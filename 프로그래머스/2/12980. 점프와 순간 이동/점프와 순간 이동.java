import java.util.*;

public class Solution {
    public int solution(int n) {
        
        return answer(n);
    }
    
    public int answer(int n){
        if(n==1){
            return 1;
        }
        
        if(n%2 != 0){
            return answer(n/2)+1;
        }else{
            return answer(n/2);
        }
    }
}