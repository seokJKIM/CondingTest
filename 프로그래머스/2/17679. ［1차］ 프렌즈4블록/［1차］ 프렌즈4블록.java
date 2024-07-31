import java.util.*;
class Solution {
    static char[][] map;
    static List<Point> list;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }

        while(true){
            if(!isPossible(m, n)) break;
            makeMap(m,n);
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == '0') answer++;
            }
        }
        return answer;
    }
    public static void makeMap(int r, int c){
        char[][] newMap = new char[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                newMap[i][j] = map[i][j];
            }
        }
        
        for(int i=0; i<list.size(); i++){
            Point p = list.get(i);
            
            int nr = p.r;
            int nc = p.c;
            
            newMap[nr][nc] = '0';
            newMap[nr+1][nc] = '0';
            newMap[nr][nc+1] = '0';
            newMap[nr+1][nc+1] = '0';
            
        }
        
        for(int i=0; i<c; i++){
            for(int j=r-1; j>=0; j--){
                if(newMap[j][i] == '0'){
                    for(int k=j-1; k>=0; k--){
                        if(newMap[k][i] != '0'){
                            newMap[j][i] = newMap[k][i];
                            newMap[k][i] = '0';
                            break;
                        }
                    }
                }    
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                map[i][j] = newMap[i][j];
            }
        }
    }
    
    public static boolean isPossible(int r, int c){
        list = new ArrayList<>();
        boolean check = false;
        for(int i=0; i<r-1; i++){
            for(int j=0; j<c-1; j++){
                if(map[i][j] != '0' && map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] && map[i][j] == map[i+1][j+1]) {
                    list.add(new Point(i,j));
                    check = true;
                }
            }
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
}