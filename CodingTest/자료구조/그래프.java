package 자료구조;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 그래프 {
    public int[][] dirGraph1(int n, int m, List<int[]> degList) { // n: 노드, m : 간선
        int[][] graph = new int[n+1][n+1];
        for (int i=0; i<m; i++) {
            int[] deg = degList.get(i);
            int a = deg[0];
            int b = deg[1];

            graph[a][b] = 1;
        }

        return graph;
    }

    public List<List<Integer>>  dirGraph2(int n, int m, List<int[]> degList) { // n: 노드, m : 간선
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        } 

        for (int i=0; i<m; i++) {
            int[] deg = degList.get(i);
            int a = deg[0];
            int b = deg[1];

            graph.get(a).add(b);
        }

        return graph;
    }

    public Map<Integer, List<Integer>> dirGraph3(int n, int m, List<int[]> degList) { // n: 노드, m : 간선
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i=0; i<m; i++) {
            int[] deg = degList.get(i);
            int a = deg[0];
            int b = deg[1];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
        }

        return graph;
    }

    public int[][] undirGraph1(int n, int m, List<int[]> degList) { // n: 노드, m : 간선
        int[][] graph = new int[n+1][n+1];
        for (int i=0; i<m; i++) {
            int[] deg = degList.get(i);
            int a = deg[0];
            int b = deg[1];

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        return graph;
    }

    public List<List<Integer>> undirGraph2(int n, int m, List<int[]> degList) { // n: 노드, m : 간선
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        } 

        for (int i=0; i<m; i++) {
            int[] deg = degList.get(i);
            int a = deg[0];
            int b = deg[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return graph;
    }

    public Map<Integer, List<Integer>> undirGraph3(int n, int m, List<int[]> degList) { // n: 노드, m : 간선
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i=0; i<m; i++) {
            int[] deg = degList.get(i);
            int a = deg[0];
            int b = deg[1];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return graph;
    }
}
