class Solution {
    public int[] solution(String s) {
        int zeroCount = 0;
        int count = 0;
        
        while(s.length() > 1){
            count++;
            String tmp = "";
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1') tmp += "1";
                else zeroCount++;
            }            
            s = Integer.toBinaryString(tmp.length());
        }
        int[] answer = {count, zeroCount};
        return answer;
    }
}