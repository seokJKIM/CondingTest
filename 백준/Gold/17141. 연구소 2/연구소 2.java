import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N, M, ans;
    static int[][] map;
    static ArrayList<Virus> two;
    static Queue<Virus> q;
    static int[][] deltas = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {


        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        ans = Integer.MAX_VALUE;
        map = new int[N][N];
        two = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(input.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(tokens.nextToken());

                if (num == 2) {
                    two.add(new Virus(i, j, 0));
                    map[i][j] = 0;
                } else {
                    map[i][j] = num;
                }
            }
        }

        combination(new boolean[two.size()], 0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static void combination(boolean[] visited, int start, int lv) {
        if (lv == M) {
            bfs(visited);
            return;
        }

        for (int i = start; i < two.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(visited, i + 1, lv + 1);
                visited[i] = false;
            }
        }
    }

    public static void bfs(boolean[] visited) {
        q = new LinkedList<>();
        int[][] newMap = make(visited);
        boolean[][] checkMap = new boolean[N][N];

        while (!q.isEmpty()) {
            Virus virus = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = virus.r + deltas[i][0];
                int nc = virus.c + deltas[i][1];

                if (isIn(nr, nc) && newMap[nr][nc] == 0) {
                    newMap[nr][nc] = virus.lv + 1;
                    checkMap[nr][nc] = true;
                    q.add(new Virus(nr, nc, virus.lv + 1));
                }
            }
        }

        int max = 0;
        boolean check = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (checkMap[i][j])
                    max = Math.max(max, newMap[i][j]);
                if (newMap[i][j] == 0) {
                    check = false;
                    break;
                }

            }
        }
        if (check) ans = Math.min(ans, max);

    }

    public static int[][] make(boolean[] visited) {
        int[][] newMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                Virus virus = two.get(i);

                newMap[virus.r][virus.c] = 2;

                q.add(virus);
            }
        }

        return newMap;
    }

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static class Virus {
        int r;
        int c;
        int lv;

        public Virus(int r, int c, int lv) {
            this.r = r;
            this.c = c;
            this.lv = lv;
        }
    }
}