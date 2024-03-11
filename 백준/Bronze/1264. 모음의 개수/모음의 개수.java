import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static char[] arr = {'a','e','i','o','u'};
    public static void main(String[] args) throws IOException {

        while(true){
            String st = input.readLine();

            if(st.equals("#")) break;

            int cnt = 0;
            for(int i=0; i<st.length(); i++){
                char c = Character.toLowerCase(st.charAt(i));

                for(int j=0; j<arr.length; j++){
                    if(c == arr[j]) cnt++;
                }
            }

            output.append(cnt).append("\n");
        }

        System.out.println(output);
    }
}