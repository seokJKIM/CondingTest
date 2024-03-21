import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N, x;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(input.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            x = Integer.parseInt(input.readLine());

            if(x == 0){
                if(pq.size() == 0) output.append(0).append("\n");
                else output.append(pq.poll()*(-1)).append("\n");
            }else pq.add(x*(-1));
        }

        System.out.println(output);
    }
}
