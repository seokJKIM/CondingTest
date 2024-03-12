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
    static char[][] map;
    static int R,C;
    static ArrayList<Point> list;
    static boolean[][] visited;
    static Queue<Point> q;
    static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
    static int kAns, vAns;
    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());

        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());

        kAns = 0;
        vAns = 0;

        map = new char[R][C];

        list = new ArrayList<>();
        visited = new boolean[R][C];
        for(int i=0; i<R; i++){
            String st = input.readLine();
            for(int j=0; j<st.length(); j++){
                char c = st.charAt(j);
                map[i][j] = c;

                if(c == 'v') list.add(new Point(i,j,'v'));
                else if(c=='k') list.add(new Point(i,j,'k'));
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == 'v') bfs(new Point(i,j,'v'));
                else if(map[i][j] == 'k') bfs(new Point(i,j,'k'));
            }
        }
        System.out.println(kAns+" "+vAns);


    }
    static void bfs(Point point){
        q = new LinkedList<>();
        q.add(point);

        int vCount = 0;
        int kCount = 0;


        while(!q.isEmpty()){
            Point p = q.poll();

            visited[point.r][point.c] = true;

            if(p.animal == 'v') vCount++;
            else if(p.animal == 'k') kCount++;

            for(int i=0; i<4; i++){
                int nr = p.r+deltas[i][0];
                int nc = p.c+deltas[i][1];

                if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] != '#'){
                    q.add(new Point(nr,nc,map[nr][nc]));
                    visited[nr][nc] = true;
                    map[nr][nc] = '#';
                }
            }
        }

        if(vCount >= kCount) vAns += vCount;
        else kAns += kCount;

    }

    static boolean isIn(int r, int c){
        return 0<=r && r<R && 0<=c && c<C;
    }

    static class Point{
        int r;
        int c;
        char animal;

        public Point(int r, int c, char animal) {
            this.r = r;
            this.c = c;
            this.animal = animal;
        }
    }
}