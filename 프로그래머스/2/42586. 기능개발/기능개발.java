import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int max = Integer.MIN_VALUE;
        int[] arr = new int[progresses.length];
        
        int[] count = new int[101];
        for(int i=0; i<arr.length; i++){
            if((100-progresses[i])%speeds[i] == 0) arr[i] = (100-progresses[i])/speeds[i];
            else arr[i] = (100-progresses[i])/speeds[i]+1;
            if(max <= arr[i]){
                max = arr[i];
            }else{
                arr[i] = max;
            }
            
            count[arr[i]]++;
        }
        
        for(int i=0; i<count.length; i++){
            if(count[i] != 0) answer.add(count[i]);
        }
        
        return answer;
    }
}