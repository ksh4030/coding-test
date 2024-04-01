import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i=4; i<11; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }
    }
}