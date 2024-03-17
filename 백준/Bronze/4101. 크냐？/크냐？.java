import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int a,b;
    public static void main(String[] args) throws IOException {

        while(true){
            tokens = new StringTokenizer(input.readLine());

            a = Integer.parseInt(tokens.nextToken());
            b = Integer.parseInt(tokens.nextToken());

            if(a==0 && b==0) break;
            if(a>b) output.append("Yes").append("\n");
            else output.append("No").append("\n");
        }
        System.out.println(output);
    }
}
