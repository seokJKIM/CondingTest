import java.util.*;

class Solution {
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
    static int bLen;
    static int[][][] map;
    static int min;
    
    public int solution(int[][] board) {
        int answer = 0;
        bLen = board.length;
        map = new int[4][bLen][bLen];
        
        for(int i=0; i<4; i++){
            for(int r=0; r<bLen; r++){
                for(int c=0; c<bLen; c++){
                    map[i][r][c] = Integer.MAX_VALUE;
                }
            }
        }

        bfs(board);
        
        min = Integer.MAX_VALUE;
        for(int i=0; i<4; i++){
            min = Math.min(min,map[i][bLen-1][bLen-1]);
        }
        return min;
    }
    
    public static void bfs(int[][] board){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,-1,0));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            int r = p.r;
            int c = p.c;
            int dir = p.dir;
            int sum = p.sum;
            
            for(int i=0; i<4; i++){
                int nr = r+deltas[i][0];
                int nc = c+deltas[i][1];
                int nSum = sum;
             
                if(dir == -1 || dir == i){
                    nSum += 100;
                }else{
                    nSum += 600;
                }
                
                if(isIn(nr,nc) && board[nr][nc] == 0 && map[i][nr][nc] >= nSum){
                    map[i][nr][nc] = nSum;
                    q.add(new Point(nr,nc,i,nSum));
                }
            }
        }
        
    }
    
    public static boolean isIn(int r, int c){
        return r>=0 && r<bLen && c>=0 && c<bLen;
    }

    public static class Point{
        int r;
        int c;
        int dir;
        int sum;
        
        Point(int r, int c, int dir, int sum){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.sum = sum;
        }
    }
}