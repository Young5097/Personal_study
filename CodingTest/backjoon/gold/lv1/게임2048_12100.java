package backjoon.gold.lv1;

/*
 * https://www.acmicpc.net/problem/12100
 * 
 * 1. 한 행으로 기울이기 : <- 
 * 2. 회전으로 4방향 이동 대체하기 : 좌/0, 하/90, 우/180, 상/270
 * 3. 재귀를 통해 4^5번 진행
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 게임2048_12100 {
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        game(board, 0);
        System.out.println(result);

    }

    public static void game(int[][] board, int depth) {
        if (depth == 5) {
            for (int i=0;i<N;i++) {
                for (int j=0; j<N; j++) {
                    result = Math.max(result, board[i][j]);
                }
            }
            return;
        }

        for (int dir=0; dir<4; dir++) {
            int[][] new_board = copyArr(board);

            for (int r=0; r<dir; r++) {
                new_board = rotate(new_board);
            }
            new_board = pull(new_board);
            game(new_board, depth + 1);
        }
    }

    public static int[][] pull(int[][] board) {
        for (int i=0; i<N; i++) {
            int[] new_row = new int[N];
            int idx = 0;

            for (int j=0; j<N; j++) {
                if (board[i][j] == 0) continue;

                if (new_row[idx] == 0) {
                    new_row[idx] = board[i][j];
                } else if (new_row[idx] == board[i][j]) {
                    new_row[idx] *= 2;
                    idx += 1;
                } else {
                    idx += 1;
                    new_row[idx] = board[i][j];
                }
            }
            board[i] = new_row;
        }
        return board;
    }

    public static int[][] rotate(int[][] board) {
        int[][] new_board = new int[N][N];
        for (int i=0;i<N;i++) {
            for (int j=0; j<N; j++) {
                new_board[i][j] = board[N-j-1][i];
            }
        }
        return new_board;
    }

    public static int[][] copyArr(int [][] arr) {
        int[][] backup = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                backup[i][j] = arr[i][j];
            }
        }
        return backup;
    }
}
