import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        // 각 문자열에 대해 처리
        for (int i = 0; i < s.length; i++) {
            answer[i] = rearrange(s[i]);
        }
        return answer;
    }
    // 주어진 문자열에서 "110"을 뽑아내고 사전순으로 가장 앞에 오게 재배치하는 함수
    private String rearrange(String str) {
        Stack<Character> stack = new Stack<>();
        int count110 = 0;

        // 먼저 문자열에서 "110"을 모두 제거하면서 카운팅
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            
            // 스택의 최근 세 문자가 "110"이라면 제거
            if (stack.size() >= 3) {
                char third = stack.pop();
                char second = stack.pop();
                char first = stack.pop();
                
                if (first == '1' && second == '1' && third == '0') {
                    count110++;  // "110"을 제거하고 카운트 증가
                } else {
                    stack.push(first);
                    stack.push(second);
                    stack.push(third);
                }
            }
        }

        // "110"을 제거한 후의 문자열을 다시 구성
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        String no110String = sb.toString();

        // "110"을 적절한 위치에 삽입
        // 가능한 많은 '1' 뒤에 삽입
        int insertPos = no110String.lastIndexOf("0") + 1; // 마지막 '0' 뒤에 삽입하는 것이 최적
        StringBuilder finalResult = new StringBuilder();
        
        finalResult.append(no110String.substring(0, insertPos)); // 0까지의 문자열 추가
        for (int i = 0; i < count110; i++) {
            finalResult.append("110"); // 모든 "110" 삽입
        }
        finalResult.append(no110String.substring(insertPos)); // 나머지 문자열 추가

        return finalResult.toString();
    }
}