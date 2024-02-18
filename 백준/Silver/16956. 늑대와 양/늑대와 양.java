import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int R, C;
    static boolean result;
    static char[][] map;
    static int[][] deltas = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());

        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());

        map = new char[R][C];

        list = new ArrayList<>();

        result = true;

        for(int i=0; i<R; i++){

            String st = input.readLine();

            for(int j=0; j<C; j++){
                map[i][j] = st.charAt(j);

                if(map[i][j] == 'S') list.add(new int[]{i, j});
            }
        }

        for(int i=0; i< list.size(); i++){
            int[] arr = list.get(i);

            int r = arr[0];
            int c = arr[1];

            check(r,c);
        }

        replace();
        print();

        System.out.println(output);

    }

    public static void print(){
        output.append("1").append("\n");
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                output.append(map[i][j]);
            }
            output.append("\n");
        }
    }
    public static void replace(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == '.') map[i][j] = 'D';
            }
        }
    }

    public static void check(int r, int c){

        for(int i=0; i<4; i++){
           int nr = r+deltas[i][0];
           int nc = c+deltas[i][1];

           if(isIn(nr, nc)){
               if(map[nr][nc] == 'W') {
                   System.out.println("0");
                   System.exit(0);
               };
           }
        }
    }

    public static boolean isIn(int r, int c){
        return 0<=r && r<R && 0<=c && c<C;
    }
}