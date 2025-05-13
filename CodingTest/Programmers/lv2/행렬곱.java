/*  
    https://school.programmers.co.kr/learn/courses/30/lessons/12949

 * 행렬곱이 성사될려면 arr1의 열과 arr2의 행 길이가 같아야함
 * 해당 문제에서는 행렬곱이 가능한거만 주어짐
 */

public class 행렬곱 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Row = arr1.length;
        int arr1Col = arr1[0].length;
        int arr2Col = arr2[0].length;

        int[][] answer = new int[arr1Row][arr2Col];

        for (int i = 0; i < arr1Row; i++) {
            for (int j = 0; j < arr2Col; j++) {
                for (int k = 0; k < arr1Col; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
