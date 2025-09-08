package backjoon.gold.lv3;

/*
 * https://www.acmicpc.net/problem/18808
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 스티커붙이기_18808 {
    static int N, M, K;
    static int[][] notebook;
    static List<int[][]> stickers = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);  // 세로
            M = Integer.parseInt(input[1]);  // 가로
            K = Integer.parseInt(input[2]);  // 스티커 개수

            notebook = new int[N][M];
        
        for (int i = 0; i < K; i++) {
            String[] stickerSize = br.readLine().split(" ");
            int R = Integer.parseInt(stickerSize[0]);  // 스티커 세로
            int C = Integer.parseInt(stickerSize[1]);  // 스티커 가로
            
            int[][] sticker = new int[R][C];
            for (int j = 0; j < R; j++) {
                String[] row = br.readLine().split(" ");
                for (int k = 0; k < C; k++) {
                    sticker[j][k] = Integer.parseInt(row[k]);
                }
            }
            stickers.add(sticker);
        }

        int idx = 0;
        while (idx != stickers.size()) {
            int[][] sticker = stickers.get(idx);
            boolean isPossible = false;

            for (int r=0; r<4; r++) {
                for (int i=0; i<N && !isPossible; i++) {
                    for (int j=0; j<M && !isPossible; j++) {
                        if (isAttach(i, j, sticker)) { // 못붙이는 스티커는 걍 버려짐
                            isPossible = true;
                            break;
                        }
                    }
                }

                if (isPossible) {
                    break;
                }

                sticker = turnStickers(sticker);
            }
            idx++;
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j] == 1) result++;
            }
        }
        System.out.println(result);
    }

    public static boolean isAttach(int x, int y, int[][] sticker) { // x·y는 모눈종이, r·c는 스티커
        int r = sticker.length;
        int c = sticker[0].length;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (x + i >= N || y + j >= M || (notebook[x+i][y+j] == 1 && sticker[i][j] == 1)) {
                    return false;
                }
            }
        }
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (sticker[i][j] == 1) {
                    notebook[x+i][y+j] = 1;
                }
            }
        }
        return true;
    }

    // 시계방향 회전
    public static int[][] turnStickers(int[][] sticker) {
        int new_x = sticker[0].length;
        int new_y = sticker.length;
        int[][] new_sticker = new int[new_x][new_y];
        for (int i=0; i<new_x; i++) {
            for (int j=0; j<new_y; j++) {
                new_sticker[i][j] = sticker[new_y-j-1][i]; // N이 원래 5일때 0,0 -> 0,4가 됐으므로 0- > 5로 간거임 
            }
        }
        return new_sticker;
    }
}

