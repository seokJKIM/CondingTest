import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N, L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());
        L = Integer.parseInt(tokens.nextToken());

        arr = new int[N];

        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<N; i++){
            if(arr[i]<=L) L++;
        }
        System.out.println(L);
    }
}
