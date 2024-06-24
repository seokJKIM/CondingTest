import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
    public static void main(String[] args) throws IOException {
        String st = input.readLine();

        for(int i=0; i<arr.length; i++) st = st.replace(arr[i], " ");
        
        System.out.println(st.length());
    }
}