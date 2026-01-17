package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 유기농배추_1012 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]); // 가로
            int N = Integer.parseInt(input[1]); // 세로
            int K = Integer.parseInt(input[2]); // 배추 위치 개수
            
            int[][] field = new int[N][M]; // N x M 배열
            
            for (int i = 0; i < K; i++) {
                String[] coord = br.readLine().split(" ");
                int x = Integer.parseInt(coord[0]);
                int y = Integer.parseInt(coord[1]);
                field[y][x] = 1; // 배추 위치 표시
            }
            
            boolean[][] visited = new boolean[N][M];
            Stack<int[]> stack = new Stack<>();
            int answer = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        answer++;
                        visited[i][j] = true;
                        stack.add(new int[] {i,j});
                        while(!stack.isEmpty()) {
                            int[] point = stack.pop();
                            int x = point[0];
                            int y = point[1];

                            for (int k=0; k<4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];
                                if (nx >= 0 && ny >=0 && nx < N && ny < M 
                                    && field[nx][ny] == 1
                                    && !visited[nx][ny]
                                ) {
                                    visited[nx][ny] = true;
                                    stack.add(new int[] {nx, ny});
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(answer);
        }
    }
}