import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, M, cnt;

    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        cnt = 0;

        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            list.add(input.readLine());
        }

        for(int i=0; i<M; i++){
            if(list.contains(input.readLine())) cnt++;
        }

        System.out.println(cnt);
    }
}
