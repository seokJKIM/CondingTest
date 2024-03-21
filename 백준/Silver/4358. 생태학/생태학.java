import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static HashMap<String, Integer> map;
    static int cnt;
    public static void main(String[] args) throws IOException {

        map = new HashMap<>();

        while(true){
            String st = input.readLine();

            if(st == null || st.length() == 0) break;

            map.put(st, map.getOrDefault(st,0)+1);
            cnt++;
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        for(String st: list){
            double num = (double) map.get(st) / cnt * 100;
            output.append(st+" "+String.format("%.4f", num)).append("\n");
        }
        System.out.println(output);
    }
}
