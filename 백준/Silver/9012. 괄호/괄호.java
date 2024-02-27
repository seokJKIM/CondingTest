import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(input.readLine());

        for(int t=0; t<T; t++){

            ArrayDeque<Character> deque = new ArrayDeque<>();

            String st = input.readLine();

            for(int i=0; i<st.length(); i++){
                char c = st.charAt(i);

                if(deque.isEmpty()){
                    deque.addLast(c);
                    continue;
                }

                if(c == ')' && deque.peekLast() == '('){
                    deque.pollLast();
                    continue;
                }

                deque.addLast(c);
            }

            if(deque.isEmpty()) output.append("YES").append("\n");
            else output.append("NO").append("\n");
        }
        System.out.println(output);
    }
}
