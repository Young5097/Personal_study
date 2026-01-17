package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i=0; i<=N-8; i++) {
            for (int j=0; j<=M-8; j++) {
                int count1 = countDiff(board, i, j, 'W');
                int count2 = countDiff(board, i, j, 'B');
                
                answer = Math.min(answer, Math.min(count1 , count2));
            }
        }
        
        System.out.println(answer);
    }

    public static int countDiff(char[][] board, int x, int y, char firstColor) {
        int count = 0;
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                char expected;
                if ((i+j) % 2 == 0) {
                    expected = firstColor;
                } else {
                    expected = (firstColor == 'W')?'B':'W';
                }

                if (expected != board[i+x][j+y]) {
                    count++;
                }
            }
        }

        return count;
    }
}
