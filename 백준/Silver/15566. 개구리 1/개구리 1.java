import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int[][] frog, flower, wood;
    static String answer;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());

        M = Integer.parseInt(tokens.nextToken());

        answer = "";
        frog = new int[N][4];

        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());

            for(int j=0; j<4; j++){
                frog[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        flower = new int[N][2];

        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());

            for(int j=0; j<2; j++){
                flower[i][j] = Integer.parseInt(tokens.nextToken())-1;
            }
        }

        wood = new int[M][3];

        for(int i=0; i<M; i++){
            tokens = new StringTokenizer(input.readLine());

            for(int j=0; j<3; j++){
                wood[i][j] = Integer.parseInt(tokens.nextToken())-1;
            }
        }

        arr = new int[N];
        visited = new boolean[N];

        dfs(0);

        System.out.println("NO");
    }

    public static void dfs(int lv){

        if(lv == N){
            if(check()){
                output.append("YES").append("\n");

                for(int i=0; i<N; i++){
                    output.append(arr[i]+1).append(" ");
                }
                System.out.println(output);
                System.exit(0);
            }

            return;

        }

        for(int i=0; i<2; i++){
            int num = flower[lv][i];

            if(!visited[num]){
                visited[num] = true;
                arr[num] = lv;
                dfs(lv+1);
                visited[num] = false;
            }

        }
    }

    public static boolean check(){
        for(int i=0; i<M; i++){
            int a = wood[i][0];
            int b = wood[i][1];
            int subject = wood[i][2];

            int frog1 = arr[a];
            int frog2 = arr[b];

            if(frog[frog1][subject] != frog[frog2][subject]) return false;
        }
        return true;
    }
}
