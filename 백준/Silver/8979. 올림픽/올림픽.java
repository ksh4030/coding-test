import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Grade[] arr = new Grade[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            arr[i] = new Grade(num, gold, silver, bronze);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o2.gold == o1.gold) {
                if(o2.silver == o1.silver) {
                    return o2.bronze - o1.bronze;
                }
                return o2.silver - o1.silver;
            }
            return o2.gold - o1.gold;
        });

        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i].num == target) {
                for (int j = i-1; j >= 0; j--) {
                    if(!isEquals(arr[i], arr[j])) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt+1);
    }

    static boolean isEquals(Grade a, Grade b) {
        return a.gold == b.gold &&
                a.silver == b.silver &&
                a.bronze == b.bronze;
    }

    static class Grade {
        int num, gold, silver, bronze;
        public Grade(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}