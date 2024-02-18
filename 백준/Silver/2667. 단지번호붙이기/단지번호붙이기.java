import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int N, ans, count;
    static int[][] map;
    static boolean[][] visited;

    static int[][] deltas = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            String st = input.readLine();

            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.substring(j,j+1));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    count = 1;
                    ans++;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        output.append(ans).append("\n");

        for(int i: list){
            output.append(i).append("\n");
        }

        System.out.println(output);
    }
    public static void dfs(int r, int c){
        visited[r][c] = true;

        for(int i=0; i<4; i++){
            int nr = r+deltas[i][0];
            int nc = c+deltas[i][1];

            if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1){
                count++;
                dfs(nr, nc);
            }
        }
    }

    public static boolean isIn(int r, int c){
        return 0<=r && r<N && 0<=c && c<N;
    }
}
