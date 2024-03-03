import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int V, E;
	static Edge[] edge;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		
		edge = new Edge[E];

		for(int t=0; t<E; t++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			edge[t] = new Edge(a,b,c);
		}
		
		int sum = 0;
		
		Arrays.sort(edge);
		
		makeSet();
		for(int i=0; i<edge.length; i++) {
			Edge e = edge[i];
			if(union(e.a, e.b)) {
				sum += e.c;
			}
		}
		System.out.println(sum);
		
	}
	public static int findSet(int a) {
		if(arr[a] == a) {
			return a;
		}
		return arr[a] = findSet(arr[a]);
	}
	
	public static boolean union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a==b) {
			return false;
		}else {
			arr[a] = b;
			return true;
		}
	}
	
	public static void makeSet() {
		arr = new int[V+1];
		for(int v=1; v<=V; v++) {
			arr[v] = v;
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int c;
		public Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.c, o.c);
		}
		
	}
}
