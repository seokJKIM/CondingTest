import java.util.*;
class Solution {
    public long solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i=0; i<queue1.length; i++){
            q1.add((long)queue1[i]);
            sum1+=queue1[i];
        }
        
        for(int i=0; i<queue2.length; i++){
            q2.add((long)queue2[i]);
            sum2+=queue2[i];
        }
        long tot = (sum1+sum2)/2;
        long count = 0;
        while(true){
            if(count > queue1.length+1+queue2.length+1 || (sum1+sum2)%2 != 0) return -1;
            if(sum1 == tot && sum2 == tot) break;
            if(sum1 > tot){
                long num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
                count++;
            }
            
            if(sum2 > tot){
                long num = q2.poll();
                sum1 += num;
                sum2 -= num;
                q1.add(num);
                count++;
            }
        }
        return count;
    }
}
