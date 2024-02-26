import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N, cnt, answer;
    static int[] arr;
    static String st;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(input.readLine());

        arr = new int[26];

        st = input.readLine();

        cnt = 0;
        answer = 0;
        int left = 0;

        for(int right = 0; right <st.length(); right++){

            add(right);

            while(cnt > N){
                remove(left);
                left++;
            }

            answer = Math.max(answer, right-left+1);
        }

        System.out.println(answer);
    }

    public static void add(int number){
        int idx = st.charAt(number)-'a';
        arr[idx]++;
        if(arr[idx] == 1) cnt++;
    }

    public static void remove(int number){
        int idx = st.charAt(number)-'a';
        arr[idx]--;
        if(arr[idx] == 0) cnt--;
    }
}
