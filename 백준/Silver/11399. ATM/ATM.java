import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int[] sum = new int[N];
		
		sum[0] = arr[0];
		for(int i=1; i<N; i++) {
			sum[i] = sum[i-1]+arr[i];
		}
		
		int result = 0;
		
		for(int i=0; i<N; i++) {
			result += sum[i];
		}
		
		System.out.println(result);
	}

}
