class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        int A = a;
        int B = b;
        
        if(a>b){
            A = b;
            B = a;
        } 

        while(A!=B){
            answer++;
            
            if(A%2==0){
                A /= 2;
            }else{
                A = (A+1)/2;
            }
            
            if(B%2==0){
                B /= 2;
            }else{
                B = (B+1)/2;
            }
        }
        
        return answer;
    }
}