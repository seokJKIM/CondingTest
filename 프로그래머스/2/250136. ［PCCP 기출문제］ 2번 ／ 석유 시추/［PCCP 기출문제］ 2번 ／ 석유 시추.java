import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int rLen, cLen;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
    static int[] arr;
    
    public int solution(int[][] land) {
        rLen = land.length;
        cLen = land[0].length;
        
        visited = new boolean[rLen][cLen];
        arr = new int[cLen];
        
        for(int i=0; i<rLen; i++){
            for(int j=0; j<cLen; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    bfs(i, j, land);
                }
            }
        }
        
        Arrays.sort(arr);
        
        return arr[arr.length-1];
    }
    
    public static void bfs(int x, int y, int[][] land){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        
        int count = 1;
        Set<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()){
            Point p = q.poll();
            int r = p.r;
            int c = p.c;
            
            set.add(c);
            
            for(int i=0; i<4; i++){
                int nr = r+deltas[i][0];
                int nc = c+deltas[i][1];
                
                if(isIn(nr,nc) && !visited[nr][nc] && land[nr][nc] == 1){
                    q.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    count++;
                }
            }
        }
        for(int i: set){
            arr[i] += count;
        }        
    }
    
    public static boolean isIn(int r, int c) {
		return r>=0 && r<rLen && c>=0 && c<cLen;
	}
    
    public static class Point{
        int r;
        int c;
        
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}