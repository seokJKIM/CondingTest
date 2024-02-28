import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] arr = new int[101];
        for(int i=0; i<progresses.length; i++){
            int day = 0;
            int n = 100 - progresses[i];
            if(n%speeds[i] == 0) day = n/speeds[i];
            else day = n/speeds[i]+1;
            
            queue.add(day);
            arr[day]++;
        }
        
        Queue<Integer> st = new LinkedList<Integer>();
        
        int num = queue.peek();
   
        int cnt = 0;
        while(queue.size() > 0){
            if(queue.peek() <= num) {
                cnt++;
                queue.poll();
            } else {
                st.add(cnt);
                cnt = 1;
                num = queue.poll();
            }   
        }
        
        st.add(cnt);
        
        int[] answer = new int[st.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = st.poll();
        }
        return answer;
    }
}