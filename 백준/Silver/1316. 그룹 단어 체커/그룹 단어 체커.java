import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static String st;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        int answer = 0;
        for(int i=0; i<N; i++){
            boolean check = true;
            arr = new int[26];

            st = input.readLine();

            for(int j=0; j<st.length()-1; j++){
                if(st.charAt(j) != st.charAt(j+1)){
                    if(arr[st.charAt(j)-'a'] == 0 ){
                        arr[st.charAt(j)-'a']++;
                    }else{
                        check = false;
                        break;
                    }
                }
            }
            if(arr[st.charAt(st.length()-1)-'a'] != 0) check = false;

            if(check) answer++;
        }

        System.out.println(answer);
    }
}