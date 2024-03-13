import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int[] arr, choice;
    static int answer;
    public static void main(String[] args) throws IOException {

        arr = new int[10];
        choice = new int[10];
        answer = 0;
        tokens = new StringTokenizer(input.readLine());

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int lv){
        if(lv == 10){
            int sum = 0;

            for(int i=0; i<10; i++){
                if(arr[i] == choice[i]) sum++;
            }
            if(sum >= 5) answer++;
            return;
        }

        for(int i=1; i<6; i++){
            if(lv>1 && choice[lv-1] == i && choice[lv-2] == i) continue;

            choice[lv] = i;
            dfs(lv+1);
            choice[lv] = 0;
        }
    }
}