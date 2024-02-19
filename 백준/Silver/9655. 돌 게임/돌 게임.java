import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for(int i=4; i<1001; i++){
            dp[i] = Math.min(dp[i-1], dp[i-3])+1;
        }

        if(dp[N]%2 == 0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }
}
