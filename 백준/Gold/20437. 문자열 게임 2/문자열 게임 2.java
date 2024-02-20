import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int K,T,min,max;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(input.readLine());
        for(int t=0; t<T; t++){

            String st = input.readLine();
            K = Integer.parseInt(input.readLine());
            int[] arr = new int[26];
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            if(K==1){
                System.out.println("1 1");
                continue;
            }
            for(int i=0; i<st.length(); i++){
                arr[st.charAt(i)-'a']++;
            }

            for(int i=0; i<st.length()-K+1; i++){
                char c = st.charAt(i);

                if(arr[c-'a'] >= K){
                    int tmp = 1;

                    for(int j=i+1; j<st.length(); j++){
                        if(c == st.charAt(j)){
                            tmp++;

                            if(tmp == K){
                                min = Math.min(min, j-i+1);
                                max = Math.max(max, j-i+1);
                                break;
                            }
                        }
                    }
                }
            }

            if(max != Integer.MIN_VALUE && min != Integer.MIN_VALUE){
                System.out.println(min+" "+max);
            }else{
                System.out.println("-1");
            }

        }

    }
}