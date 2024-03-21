import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(input.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(tokens.nextToken()));
        }

        for(int i=1; i<N; i++){
            tokens = new StringTokenizer(input.readLine());

            for(int j=0; j<N; j++){
                int num = Integer.parseInt(tokens.nextToken());

                if(pq.peek()<num){
                    pq.poll();
                    pq.add(num);
                }
            }
        }

        System.out.println(pq.peek());
    }
}
