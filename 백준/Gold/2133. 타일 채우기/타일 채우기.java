import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        dp = new int[N+1];
        dp[0] = 1;

        for(int i=2; i<N+1; i+=2){
            dp[i] = dp[i-2]*3;

            for(int j=i-4; j>=0; j-=2){
                dp[i] += dp[j]*2;
            }
        }

        System.out.println(dp[N]);
    }
}
