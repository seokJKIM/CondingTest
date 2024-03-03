import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();

     public static void main(String[] args) throws IOException {

        T = Integer.parseInt(input.readLine());

        for(int t=1; t<=T; t++){
            tokens = new StringTokenizer(input.readLine());

            int J = Integer.parseInt(tokens.nextToken());

            int N = Integer.parseInt(tokens.nextToken());

            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                tokens = new StringTokenizer(input.readLine());

                int R = Integer.parseInt(tokens.nextToken());

                int C = Integer.parseInt(tokens.nextToken());


                arr[i] = R*C;
            }

            Arrays.sort(arr);

            int sum = 0;
            int answer = 0;
            for(int i=0; i<arr.length; i++){
                sum += arr[arr.length-i-1];

                answer++;

                if(sum >= J) break;
            }

            output.append(answer).append("\n");
        }

        System.out.println(output);
    }
}
