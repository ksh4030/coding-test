import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int answer = 0;

        int[] arr = new int[N];
        int[] nArr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        nArr[0] = arr[0];

        for (int i = 1; i < N; i++) {
            nArr[i] = nArr[i - 1] + arr[i];
        }

        for(int n : nArr) {
            answer += n;
        }

        System.out.println(answer);

    }
}