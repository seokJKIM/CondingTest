import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        String st = input.readLine();

        String ans ="";
        for(int i=0; i<st.length(); i++){
            char c = st.charAt(i);
            if(Character.isUpperCase(c)){
                ans+=Character.toLowerCase(c);
            }else{
                ans+=Character.toUpperCase(c);
            }
        }
        System.out.println(ans);

    }
}