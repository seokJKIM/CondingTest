class Solution {
    static int[] arr;
    
    public int solution(int n) {
        int answer = 0;
        arr = new int[n+1];
        answer = makeFibo(n) % 1234567;
        return answer;
    }
    
    public static int makeFibo(int num){
        if(num == 1) {
            return 1;
        }else if(num == 0){
            return 0;
        }
        
        if(arr[num] != 0) return arr[num]%1234567;
        
        return arr[num] = (makeFibo(num-2)+makeFibo(num-1))%1234567;
    }
}