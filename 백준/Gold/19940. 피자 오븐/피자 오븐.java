import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int[] arr = new int[5];
            int N = Integer.parseInt(br.readLine());

            // ADDH
            arr[0] += N / 60;
            N %= 60;

            // 조건문
            if (N <= 35) {
                if (N % 10 > 5) {
                    arr[1] += N / 10 + 1;      // ADDT
                    arr[4] += 10 - (N % 10);   // MINO
                } else {
                    arr[1] += N / 10;          // ADDT
                    arr[3] += N % 10;          // ADDO
                }
            } else {
                arr[0]++;
                if (N % 10 >= 5) {
                    arr[2] += 6 - (N / 10 + 1); // MINT
                    arr[4] += 10 - (N % 10);    // MINO
                } else {
                    arr[2] += 6 - (N / 10);     // MINT
                    arr[3] += N % 10;           // ADDO
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int n : arr) {
                sb.append(n).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
