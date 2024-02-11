import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int lidx = 0;
        int ridx = people.length-1;
        
        while(lidx<=ridx){
            if(people[lidx] + people[ridx] <= limit){
                answer++;
                lidx++;
                ridx--;
            }else{
                answer++;
                ridx--;
            }
        }
        
        return answer;
    }
}