class Solution {

    static int[] dr = {1,0,-1};
    static int[] dc = {0,1,-1};
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int num = 1;

        int idx=0;

        int nr=0; 
        int nc=0;
        
        arr[0][0] = num++;

        int limit = (int) ((n+1) * ((double) n/2));
        
        while(num<=limit) {
            idx = idx % 3;
            nr = nr+dr[idx];
            nc = nc+dc[idx];

            if(nr>=0 && nr<n && nc>=0 && nc<n && arr[nr][nc] == 0) {
                arr[nr][nc] = num++;
            } else {
                nr = nr-dr[idx];
                nc = nc-dc[idx];
                idx++;
            }
        }

              
        int index = 0;
        int[] result = new int[limit];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<=i; j++){
                result[index++] = arr[i][j];
            }
        }
        
        
        return result;
    }
}