import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringTokenizer tokens;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(input.readLine());

        HashMap<Integer, Integer> map = new HashMap();

        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(tokens.nextToken());
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        int number = Integer.parseInt(input.readLine());
        System.out.println(map.get(number)==null? 0 : map.get(number));

    }
}
