import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int target;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(set.size() / target);
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        String tmp = st.nextToken();

        if(tmp.equals("Y")) target = 1;
        else if (tmp.equals("F")) target = 2;
        else target = 3;

        for(int i=0; i<N; i++) set.add(br.readLine());
    }

}