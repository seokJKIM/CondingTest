import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringTokenizer tokens;
    static long[][] arr;
    public static void main(String[] args) throws IOException {

        int mod = 1000000000;

        N = Integer.parseInt(input.readLine());

        arr = new long[N+1][10];
        arr[1][1] = 0;

        for(int i=1; i<10; i++){
            arr[1][i] = 1;
        }

        for(int i=2; i<N+1; i++){

            for(int j=0; j<10; j++){
                if(j==0) arr[i][j] = arr[i-1][1]%mod;
                else if(j==9) arr[i][j] = arr[i-1][8]%mod;
                else arr[i][j] = (arr[i-1][j-1]+arr[i-1][j+1])%mod;
            }
        }

        long ans = 0;
        for(int i=0; i<10; i++){
            ans += arr[N][i];
        }

        System.out.println(ans%mod);
    }
}
