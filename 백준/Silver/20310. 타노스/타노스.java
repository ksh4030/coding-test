import java.io.*;
import java.util.Arrays;

public class Main {
    static int zero;
    static int one;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        init();
        greedy();
        write();
    }

    public static void write() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if(!arr[i].equals(" ")) sb.append(arr[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void greedy() {
        int idx = arr.length-1;
        while (zero > 0) {
            if(arr[idx].equals("0")) {
                arr[idx] = " ";
                zero--;
            }
            idx--;
        }

        idx = 0;
        while (one > 0) {
            if(arr[idx].equals("1")) {
                arr[idx] = " ";
                one--;
            }
            idx++;
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().split("");

        zero = 0;
        one = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("0")) zero++;
            if (arr[i].equals("1")) one++;
        }

        zero /= 2;
        one /= 2;
    }

}
