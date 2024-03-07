import java.util.*;

class Solution { 
    static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] visited;
    static Queue<Point> q;
    static int row, col;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        row = maps.length;
        col = maps[0].length;
        
        visited = new boolean[row][col];
        
        bfs(maps);
        
        return maps[row-1][col-1] == 1 ? -1 : maps[row-1][col-1];
    }
    
    public static void bfs(int[][] maps){
        q = new LinkedList<>();
        
        q.add(new Point(0,0,1));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            int r = p.r;
            int c = p.c;
            int lv = p.lv;
            
            for(int i=0; i<4; i++){
                int nr = r+deltas[i][0];
                int nc = c+deltas[i][1];
                
                if(isIn(nr, nc) && !visited[nr][nc] && maps[nr][nc] == 1){
                    visited[nr][nc] = true;
                    maps[nr][nc] = lv+1;
                    q.add(new Point(nr,nc,lv+1));
                }
            }
        }
    }
    
    public static boolean isIn(int r, int c){
        return 0 <= r && r < row && 0 <= c && c < col;
    }
    
    public static class Point{
        int r;
        int c;
        int lv;
        public Point(int r, int c, int lv){
            this.r = r;
            this.c = c;
            this.lv = lv;
        }
    }
}