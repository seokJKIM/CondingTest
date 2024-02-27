import java.util.*;

class Solution {
    public List<Long> solution(int n, long left, long right) {

        ArrayList<Long> list = new ArrayList<>();
        
        for(long i=left; i<right+1; i++){
            list.add((long)(Math.max(i/n, i%n))+1);
        }
        
        return list;
    }
}
       
    

// n(i-1)+j > left &&  n(i-1)+j-1 <= right
 //  (0 2) (1 2)
// 1 2 3 4
// 2 2 3 4
// 3 3 3 4
// 4 4 4 4    