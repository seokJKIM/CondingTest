import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());

            String st = tokens.nextToken();

            if(st.equals("push")){
                deque.addLast(Integer.parseInt(tokens.nextToken()));
            }else if(st.equals("front")){
                if(deque.isEmpty()){
                    output.append("-1").append("\n");
                }else{
                    output.append(deque.peekFirst()).append("\n");
                }
            }else if(st.equals("pop")){
                if(deque.isEmpty()){
                    output.append("-1").append("\n");
                }else{
                    output.append(deque.removeFirst()).append("\n");
                }
            }else if(st.equals("back")){
                if(deque.isEmpty()){
                    output.append("-1").append("\n");
                }else{
                    output.append(deque.peekLast()).append("\n");
                }
            }else if(st.equals("size")){
                output.append(deque.size()).append("\n");
            }else if(st.equals("empty")){
                if(deque.isEmpty()) output.append("1").append("\n");
                else output.append("0").append("\n");
            }
        }
        System.out.println(output);
    }
}