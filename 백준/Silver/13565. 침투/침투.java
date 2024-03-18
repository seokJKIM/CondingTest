import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int M, N;
    static int[][] map;
    static ArrayList<Point> list;
    static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());

        M = Integer.parseInt(tokens.nextToken());
        N = Integer.parseInt(tokens.nextToken());

        map = new int[M][N];
        list = new ArrayList<>();

        for(int i=0; i<M; i++){
            String st = input.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.substring(j,j+1));

                if(i==0  && map[i][j] == 0) list.add(new Point(i,j));
            }
        }

        bfs();

        System.out.println(check()?"YES":"NO");
    }

    public static void bfs(){

        Queue<Point> q = new LinkedList<>(list);

        while(!q.isEmpty()){

            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nr = p.r+deltas[i][0];
                int nc = p.c+deltas[i][1];

                if(isIn(nr,nc) && map[nr][nc] == 0) {
                    q.add(new Point(nr,nc));
                    map[nr][nc] = 2;
                }
            }
        }
    }

    public static boolean check(){

        boolean check = false;

        for(int i=0; i<N; i++){
            if(map[M-1][i]==2) check = true;
        }

        return check;
    }

    public static class Point{
        int r;
        int c;

        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static boolean isIn(int r, int c){
        return 0<=r && r<M && 0<=c && c<N;
    }
}
