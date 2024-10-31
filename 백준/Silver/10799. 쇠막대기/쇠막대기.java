import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        int answer = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("(")) {
                stack.push(arr[i]);
            } else {
                stack.pop();
                if(arr[i-1].equals(")")) {
                    answer++;
                } else {
                    answer += stack.size();
                }
            }
        }
        System.out.println(answer);
    }
}