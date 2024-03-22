import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static PriorityQueue<Problem> easy, hard;
    static int[] arr = new int[100001];
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        easy = new PriorityQueue<>();

        hard = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            int number = Integer.parseInt(tokens.nextToken());
            int lv = Integer.parseInt(tokens.nextToken());

            Problem p = new Problem(number, lv);
            easy.add(p);
            hard.add(p);
            arr[number] = lv;
        }

        M = Integer.parseInt(input.readLine());

        for(int i=0; i<M; i++){
            tokens = new StringTokenizer(input.readLine());
            String st = tokens.nextToken();

            if(st.equals("add")){
                int number = Integer.parseInt(tokens.nextToken());
                int lv = Integer.parseInt(tokens.nextToken());

                Problem p = new Problem(number, lv);
                easy.add(p);
                hard.add(p);
                arr[p.number] = p.lv;
            }else if(st.equals("recommend")){
                int number = Integer.parseInt(tokens.nextToken());

                if(number == 1){
                    while(true){
                        Problem p = hard.peek();
                        if(arr[p.number] == p.lv){
                            output.append(p.number).append("\n");
                            break;
                        }
                        hard.poll();
                    }
                }else{
                    while(true){
                        Problem p = easy.peek();

                        if(arr[p.number] == p.lv){
                            output.append(p.number).append("\n");
                            break;
                        }
                        easy.poll();
                    }
                }
            }else{
                int number = Integer.parseInt(tokens.nextToken());
                arr[number] = 0;
            }
        }
        System.out.println(output);
    }

    public static class Problem implements Comparable<Problem>{
        int number;
        int lv;

        public Problem(int number, int lv){
            this.number = number;
            this.lv = lv;
        }


        @Override
        public int compareTo(Problem o) {
            if(this.lv == o.lv){
                return Integer.compare(this.number, o.number);
            }
            return Integer.compare(this.lv, o.lv);
        }
    }
}
