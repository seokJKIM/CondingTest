import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N,L, W, H;
    static double low, high, mid;
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());
        L = Integer.parseInt(tokens.nextToken());
        W = Integer.parseInt(tokens.nextToken());
        H = Integer.parseInt(tokens.nextToken());

        low = 0;
        high = Math.min(L, Math.min(W,H));

        mid = 0;
        while(low < high){
            mid = (low + high)/2;

            long number = (long)(L/mid)*(long)(W/mid)*(long)(H/mid);

            if(number < N){
                if(high == mid) break;
                high = mid;
            } else{
                if(low == mid) break;
                low = mid;
            }
        }
        System.out.println(low);
    }
}
