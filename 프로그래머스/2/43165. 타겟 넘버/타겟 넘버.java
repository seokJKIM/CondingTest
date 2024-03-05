class Solution {
    
    static int[] calculate = {1,-1};
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        int[] choosed = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            choosed[i] = numbers[i];
        }
        dfs(0, numbers, target, choosed);        
        
        return answer;
    }
    
    static void dfs(int lv, int[] numbers, int target, int[] choosed){
        if(lv == numbers.length){
            int sum = 0;
            for(int i=0; i<choosed.length; i++){
                sum += choosed[i];
            }            
            
            if(sum == target) answer++;
            
            return;
        }
        
        for(int i=0; i<2; i++){
            choosed[lv] = choosed[lv]*calculate[i];
            dfs(lv+1, numbers, target, choosed);
        }
    }
}