import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N, K;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        map = new int[N+1][K+1];

        for(int i=0; i<N+1; i++){
            for(int j=1; j<K+1; j++){
                if(j == 1){
                    map[i][j] = 1;
                }else if(i == 0){
                    map[i][j] = 1;
                }else{
                    map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000000;
                }
            }
        }
        System.out.println(map[N][K]);
    }
}