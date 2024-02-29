import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) answer = cities.length*5;
        else{
            
            LinkedList<String> arr = new LinkedList<>();
            
            int idx = 0;
            
            for(int i=0; i<cities.length; i++){
                String st = cities[i].toUpperCase();
                
                if(arr.remove(st)){
                    answer++;
                    arr.add(st);
                }else{
                    answer+=5;
                    if(arr.size() >= cacheSize) arr.remove(0);
                    arr.add(st);
                }
            }    
        }
        
        return answer;
    }
}