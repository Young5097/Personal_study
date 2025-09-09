package backjoon.gold.lv5;

/*
 * https://www.acmicpc.net/problem/15686
 *  
 * M개의 치킨집만을 남겨서 치킨거리를 최소화 해야함
 * 근데 치킨거리를 최소화 하려면 치킨집을 최대한 많이 남겨야하므로 M개 남기면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 치킨배달_15686  {
    static int N, M = 0;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(input[j]);

                if (value == 1) {
                    houses.add(new Point(i, j));
                }
                if (value == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        getChickenDistance(0, 0, new ArrayList<>());
        System.out.println(result);
    }

    public static void getChickenDistance(int start, int depth, List<Point> selected) {
        if (depth == M) {
            int totalDistance = 0;
            for (Point house : houses) {
                int minDistance = Integer.MAX_VALUE;
                for (Point chicken : selected) {
                    int distance = getDistance(house, chicken);
                    minDistance = Math.min(minDistance, distance);
                }
                totalDistance += minDistance;
            }
            result = Math.min(result, totalDistance);
            return;
        }

        for (int i=start; i<chickens.size(); i++) {
            selected.add(chickens.get(i));
            getChickenDistance(i+1, depth+1, selected);
            selected.remove(selected.size()-1);
        }
    }

    public static int getDistance(Point house, Point chicken) {
        return Math.abs(house.x-chicken.x) + Math.abs(house.y-chicken.y);
    }
}
