import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N;
    static String[] arr;
    static String[] target;

    public static void main(String[] args) throws IOException {
        init();
        int ans = light(arr.clone(), false);
        arr[0] = arr[0].equals("0") ? "1" : "0";
        arr[1] = arr[1].equals("0") ? "1" : "0";
        int n = light(arr.clone(), true);

        if(ans == -1) {
            System.out.println(n);
        } else if (n == -1) {
            System.out.println(ans);
        } else {
            System.out.println(Math.min(ans, n));
        }
    }

    public static int light(String[] arr, boolean flag) {
        int cnt = flag ? 1 : 0;
        for (int i = 1; i < arr.length; i++) {
            if(!arr[i-1].equals(target[i-1])) {
                arr[i-1] = arr[i-1].equals("0") ? "1" : "0";
                arr[i] = arr[i].equals("0") ? "1" : "0";
                if(i < arr.length-1) arr[i+1] = arr[i+1].equals("0") ? "1" : "0";
                cnt++;
            }
        }

        return isSame(arr) ? cnt : -1;
    }

    public static boolean isSame(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i].equals(target[i])) return false;
        }
        return true;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = br.readLine().split("");
        target = br.readLine().split("");
    }
}
