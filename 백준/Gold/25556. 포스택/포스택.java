import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N;
        N = sc.nextInt();
        sc.nextLine();
        String A = sc.nextLine();
        String answer = "";

        String[] ary = A.split(" ");
        int[] stack = new int[4];
        stack[0] = Integer.parseInt(ary[0]);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 4; j++) {
                if(j==4){
                    answer="NO";
                    break;
                }
                if(stack[j] < Integer.parseInt(ary[i])){
                    stack[j] = Integer.parseInt(ary[i]);
                    break;
                } else {
                    continue;
                }
            }
            if(answer.equals("NO")){
                System.out.println(answer);
                break;
            }
        }

        if(answer.equals("")){
            answer = "YES";
            System.out.println(answer);
        }

    }
}