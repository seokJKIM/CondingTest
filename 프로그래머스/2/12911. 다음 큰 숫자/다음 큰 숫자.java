class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = 1;
        int cnt = 0;
        
        String st1 = Integer.toBinaryString(n);
        
        for(int i=0; i< st1.length(); i++){
           if(st1.charAt(i) == '1') cnt++;
        }
        
        while(true){
           int number = n+count;
           int one = 0;
           String st2 = Integer.toBinaryString(number);
           for(int i=0; i< st2.length(); i++){
               if(st2.charAt(i) == '1') one++;
           }

           if(cnt == one){
               answer = number;
               break;
           }
           count++;
       }
        
        return answer;
    }
}