import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int length, max;
    static String st;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        st = input.readLine();

        length = st.length();

        max = Integer.MIN_VALUE;

        visited = new boolean[51];

        dfs(0, 0, "");
    }

    public static void dfs(int lv, int max, String ans){
        if(lv == length){
            boolean check = true;
            for(int i=1; i<=max; i++){
                if(!visited[i]){
                    check = false;
                    break;
                }
            }

            if(check){
                System.out.println(ans);
                System.exit(0);
            }
            return;
        }

        int number = Integer.parseInt(st.substring(lv, lv+1));
        if(isIn(number)){
            visited[number] = true;
            dfs(lv+1, Math.max(max, number), ans+" "+number);
            visited[number] = false;
        }

        if(lv+1 < length){
        number = Integer.parseInt(st.substring(lv, lv+2));
            if(isIn(number)){
                visited[number] = true;
                dfs(lv+2, Math.max(max, number), ans+" "+number);
                visited[number] = false;
            }
        }
    }

    public static boolean isIn(int x){
        return x<51 && !visited[x];
    }
}