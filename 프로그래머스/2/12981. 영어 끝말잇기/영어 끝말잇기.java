import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        
        boolean check = true;
        int number = 0;
        outer: for(int i=1; i<words.length; i++){
            char lastWord = words[i-1].charAt(words[i-1].length()-1);
            if(words[i].charAt(0) != lastWord) {
                check = false;
                number = i;
                break;
            }
            
            for(int j=0; j<i; j++){
                if(words[i].equals(words[j])){
                    check = false;
                    number = i;
                    break outer;
                }
            }
        }
        
        if(!check){ 
            answer[0] = number%n+1;
            answer[1] = number/n+1;
        }
        return answer;
    }
}