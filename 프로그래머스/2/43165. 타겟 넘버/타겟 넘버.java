class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(0, numbers, target, 0);        
        
        return answer;
    }
    
    static void dfs(int lv, int[] numbers, int target, int sum){
        if(lv == numbers.length){
            if(sum == target) answer++;
            return;
        }
        
        
        dfs(lv+1, numbers, target, sum + numbers[lv]);
        dfs(lv+1, numbers, target, sum + numbers[lv]*(-1));
    }
}