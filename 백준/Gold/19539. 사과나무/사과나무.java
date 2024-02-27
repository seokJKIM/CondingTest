import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N, sum;
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(input.readLine());

        tokens = new StringTokenizer(input.readLine());

        int twoCount = 0;
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(tokens.nextToken());
            sum += number;
            twoCount += number/2;
        }

        if(sum%3 == 0 && twoCount >= sum/3) System.out.println("YES");
        else System.out.println("NO");
        
    }
}
