import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, W, count;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());
        W = Integer.parseInt(tokens.nextToken());

        list = new ArrayList[N+1];

        count = 0;
        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            tokens = new StringTokenizer(input.readLine());

            int start = Integer.parseInt(tokens.nextToken());
            int end = Integer.parseInt(tokens.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        for(int i=2; i<N+1; i++){
            if(list[i].size() == 1) count++;
        }

        System.out.println((double) W/count);
    }
}
