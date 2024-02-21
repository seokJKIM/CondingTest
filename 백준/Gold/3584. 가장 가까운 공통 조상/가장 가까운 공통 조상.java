import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int T, N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(input.readLine());

        for(int t=0; t<T; t++){
            N = Integer.parseInt(input.readLine());

            arr = new int[N+1];
            for(int i=0; i<N-1; i++){
                tokens = new StringTokenizer(input.readLine());

                int a = Integer.parseInt(tokens.nextToken());
                int b = Integer.parseInt(tokens.nextToken());

                arr[b] = a;
            }

            tokens = new StringTokenizer(input.readLine());

            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());

            solution(a, b);
        }
        System.out.println(output);
    }

    public static void solution(int a, int b){
        boolean[] visited = new boolean[N+1];

        while(a>0){
            visited[a] = true;
            a = arr[a];
        }

        while(b>0){
            if(visited[b]){
                output.append(b).append("\n");
                break;
            }

            b = arr[b];
        }
    }
}
