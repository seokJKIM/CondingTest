import java.util.*;

class Solution {
    static ArrayList<String> list;
    static char[] arr = {'A','E','I','O','U'};
    
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        
        make(0, "");       
       
        return list.indexOf(word)+1;
    }
    
    public static void make(int lv, String ans){
        if(lv >= 5) return;
        for(int i=0; i<arr.length; i++){
            list.add(ans+arr[i]);
            make(lv+1, ans+arr[i]);
        }
    }
}