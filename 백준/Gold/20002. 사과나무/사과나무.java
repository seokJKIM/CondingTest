import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N, ans;
    static int[][] map, sum;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());

        map = new int[N+1][N+1];

        ans = Integer.MIN_VALUE;

        for(int i=1; i<N+1; i++){
            tokens = new StringTokenizer(input.readLine());

            for(int j=1; j<N+1; j++){
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        sum = new int[N+1][N+1];

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+map[i][j];
            }
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                int size = Math.min(N-i, N-j);

                for(int k=0; k<=size; k++){
                    ans = Math.max(ans, sum[i+k][j+k]-sum[i-1][j+k]-sum[i+k][j-1]+sum[i-1][j-1]);
                }
            }
        }

        System.out.println(ans);
    }
}
