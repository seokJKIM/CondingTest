import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        dp = new int[N+1];

        for(int i=1; i<N+1; i++){
            dp[i] = i;
            for(int j = 1; j * j <= i; j++){
                if(dp[i] > dp[i-j*j]+1) dp[i] = dp[i-j*j]+1;
            }
        }
        System.out.println(dp[N]);
    }
}
