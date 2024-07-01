import java.util.*;

public class Solution {
    
    public int solution(int n) {
        return dfs(n);
    }
    
    public static int dfs(int n){
        if(n == 1){
            return 1;
        }
        
        if(n%2 != 0){
            return dfs(n/2)+1;
        }else{
            return dfs(n/2);
        }
    }
}