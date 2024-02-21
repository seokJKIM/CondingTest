import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, ans;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        ans = 0;
        int[] arr = new int[N];

        tokens = new StringTokenizer(input.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){
            ans += arr[i]*(arr.length-i);
        }

        System.out.println(ans);
    }
}
