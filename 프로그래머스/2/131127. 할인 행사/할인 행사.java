import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int day = 10;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<number.length; i++){
            map.put(want[i], number[i]);
        }
        
        for(int i=0; i<discount.length-day+1; i++){
            Map<String, Integer> disCountMap = new HashMap<>();
            
            for(int j=0; j<day; j++){
                disCountMap.put(discount[i+j], disCountMap.getOrDefault(discount[i+j], 0)+1);
            }
            
            boolean check = true;
            
            for(String key: map.keySet()){
                if(map.get(key) != disCountMap.get(key)){
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}