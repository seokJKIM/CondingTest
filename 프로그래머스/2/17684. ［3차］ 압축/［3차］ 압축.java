import java.util.*;
class Solution {
    String[] arr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public List<Integer> solution(String msg) {
        int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i],i+1);
        }
        int num = 27;
        int len = 1;
        int idx = 0;
        while(idx+len < msg.length()){
            String tmp = msg.substring(idx,idx+len);
            if(map.containsKey(tmp)){
                if(map.containsKey(msg.substring(idx,idx+len+1))){
                    len++;
                }else{
                    map.put(msg.substring(idx,idx+len+1), num);
                    list.add(map.get(tmp));
                    idx += len;
                    len = 1;
                    num++;
                }
            }
        }
        list.add(map.get(msg.substring(idx,msg.length())));
        return list;
    }
}