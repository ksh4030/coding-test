import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[Integer.parseInt(st.nextToken())];
        int[] cal = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cal.length; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr, cal, arr[0],1);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(cal));

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int[] arr, int[] cal, int sum, int idx) {
        if(Arrays.stream(cal).sum() == 0) {
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for(int i=0; i<4; i++) {
            if(cal[i] > 0) {
                cal[i]--;

                switch (i) {
                    case 0: 
                        dfs(arr, cal, sum + arr[idx], idx + 1);
                        break;
                    case 1: 
                        dfs(arr, cal, sum - arr[idx], idx + 1);
                        break;
                    case 2: 
                        dfs(arr, cal, sum * arr[idx], idx + 1);
                        break;
                    case 3: 
                        dfs(arr, cal, sum / arr[idx], idx + 1);
                        break;
                }
                cal[i]++;
            }
        }
    }
}