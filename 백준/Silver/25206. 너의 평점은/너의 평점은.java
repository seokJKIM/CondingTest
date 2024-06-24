import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        double sum = 0;
        double tot = 0;
        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        for(int T=0; T<20; T++){
            tokens = new StringTokenizer(input.readLine());

            tokens.nextToken();
            double score = Double.parseDouble(tokens.nextToken());
            
            String st = tokens.nextToken();
            
            if(st.equals("P")) continue;
            sum += score;
            tot += score*map.get(st);
        }
        System.out.printf("%f",tot/sum);
    }
}