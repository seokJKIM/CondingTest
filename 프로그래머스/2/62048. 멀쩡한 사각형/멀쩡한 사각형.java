class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int gcd = gcd(w,h);
        int a = w/gcd;
        int b = h/gcd;
        
        return ((long) w * h) - ((a + b - 1) * gcd);
    }
    
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}