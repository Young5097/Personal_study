package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 서로 다른 수에 대상이 되는 인덱스의 수는 포함되면 안됨
        int count = 0;
        for (int i=0; i<N; i++) {
            int target = arr[i];
            int st_idx = 0;
            int en_idx = N-1;
            while (st_idx < en_idx) {
                if (arr[st_idx] + arr[en_idx] > target) {
                    en_idx--;
                } else if (arr[st_idx] + arr[en_idx] < target) {
                    st_idx++;
                } else {
                    if (st_idx != i && en_idx != i) {
                        count++;
                        break;
                    } else if (st_idx == i) { // ex) target=-1, idx=1 -> arr[1] == -1, arr[3] == 0인 경우
                        st_idx++;
                    } else { // target==3, idx=2 -> arr[0] = 0, arr[2] == 3인 경우
                        en_idx--;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
