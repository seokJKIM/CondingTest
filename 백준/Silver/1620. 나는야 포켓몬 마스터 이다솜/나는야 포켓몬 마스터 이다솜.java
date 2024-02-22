import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static HashMap<String,String> map = new HashMap<>();
    static HashMap<String,String> map2 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());

        M = Integer.parseInt(tokens.nextToken());

        for(int i=1; i<=N; i++){
            String st = input.readLine();
            map.put(String.valueOf(i),st);
            map2.put(st,String.valueOf(i));
        }

        for(int i=0; i<M; i++){
            String st = input.readLine();

            String ans = map.get(st);
            if(ans == null) ans = String.valueOf(map2.get(st));

            output.append(ans).append("\n");
        }
        System.out.println(output);
    }
}
