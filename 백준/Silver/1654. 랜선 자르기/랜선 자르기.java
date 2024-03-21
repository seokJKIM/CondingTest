import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int K, N;
    static StringTokenizer tokens;
    static long max, min;
    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());

        K = Integer.parseInt(tokens.nextToken());
        N = Integer.parseInt(tokens.nextToken());

        max = Integer.MIN_VALUE;

        int[] arr = new int[K];

        for(int i=0; i<K; i++){
            int num = Integer.parseInt(input.readLine());
            arr[i] = num;
            max = Math.max(max, num);
        }

        min = 1;

        while(min<=max){

            long mid = (max+min)/2;

            long sum = 0;

            for(int i=0; i<arr.length; i++){
                sum += arr[i]/mid;
            }
//            System.out.println(sum +" "+mid);

            if(sum < N){
                max = mid-1;
            }else{
                min = mid+1;
            }

//            if(N == sum) break;
        }
        System.out.println(max);
    }
}
