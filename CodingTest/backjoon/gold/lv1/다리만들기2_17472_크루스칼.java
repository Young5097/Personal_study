package backjoon.gold.lv1;

import java.io.*;
import java.util.*;

public class 다리만들기2_17472_크루스칼 {
    
    static class Edge {
        int to;
        int from;
        int cost;

        public Edge(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static List<Edge> edgeList;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());  // 세로 크기
        M = Integer.parseInt(st.nextToken());  // 가로 크기
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 섬 구분하기
        int landCount = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    setLandNum(i, j, landCount);
                    landCount++;
                }
            }
        }
        landCount--;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        // 2. 다리 찾기
        edgeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int landNum = map[i][j];
                findBridge(i, j, landNum);
            }
        }
        
        // 3. MST
        Collections.sort(edgeList, (a,b) -> a.cost - b.cost);

        parents = new int[landCount+1];
        for (int i=1; i<=landCount; i++) {
            parents[i] = i;
        }

        int totalCost = 0;
        int count = 0;

        for (Edge edge : edgeList) {
            int a = edge.from;
            int b = edge.to;
            int cost = edge.cost;

            if (find(a) != find(b)) {
                parents[find(b)] = find(a);
                totalCost += cost;
                count++;
            }

            if (count == landCount - 1) break;
        }

        if (count == landCount-1) {
            System.out.println(totalCost);
        } else {
            System.out.println(-1);
        }
    }

    static void setLandNum(int x, int y, int landCount) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        map[x][y] = landCount;
        queue.offer(new int[] {x,y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                map[nx][ny] = landCount;
                queue.offer(new int[] {nx,ny});
            }
        }
    }

    static void findBridge(int x, int y, int landNum) {
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int len = 0;
            
            while (true) {
                if (nx<0 || ny<0 || nx>=N || ny>=M) break;
                if (map[nx][ny] == landNum) break;

                if (map[nx][ny] >= 1) { // 가다가 다른 섬 만남
                    if (len >= 2) {
                        edgeList.add(new Edge(map[x][y], map[nx][ny], len));
                    } 
                    break;
                }

                nx += dx[i];
                ny += dy[i];
                len++;
            }
        }
    }
    

    static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
}
