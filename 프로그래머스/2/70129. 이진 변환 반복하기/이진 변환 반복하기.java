class Solution {
    public int[] solution(String s) {
        
        int loopCnt=0;
        int zeroCnt=0;
        
        while(!s.equals("1")){
            String tmp = "";
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '1') tmp += c;
                else zeroCnt++;
            }
            
            s = Integer.toBinaryString(tmp.length());
            
            loopCnt++;
        }
        
        return new int[] {loopCnt, zeroCnt};
    }
}