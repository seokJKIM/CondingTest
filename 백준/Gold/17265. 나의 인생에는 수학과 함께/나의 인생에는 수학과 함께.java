import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, max, min;
    static char[][] map;
    static int[][] deltas = {{1,0},{0,1}};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        map = new char[N][N];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());

            for(int j=0; j<N; j++){
                map[i][j] = tokens.nextToken().charAt(0);
            }
        }

        dfs(0,0, 0, ' ');

        System.out.println(max+" "+min);
    }

    public static void dfs(int r, int c, int sum, char word){

        if(map[r][c] != '*' && map[r][c] != '+' && map[r][c] != '-'){
            sum = calculate(r, c, sum, word);
        }else{
            word = map[r][c];
        }

        if(r == N-1 && c == N-1){
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        
        for(int i=0; i<2; i++){
            int nr = r+deltas[i][0];
            int nc = c+deltas[i][1];

            if(isIn(nr, nc)){
                dfs(nr, nc, sum, word);
            }
        }
    }

    public static int calculate(int r, int c, int sum, char word){
        int num = map[r][c] -'0';
        if(word == '+' || word == ' '){
            sum += num;
        }else if(word == '-'){
            sum -= num;
        }else if(word == '*'){
            sum *= num;
        }

        return sum;
    }

    public static boolean isIn(int r, int c){
        return 0<=r && r<N && 0<=c && c<N;
    }
}
