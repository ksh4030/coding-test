import java.util.*;

class Solution {
    private static int answer;
    private static final String[] characters = {"A", "C", "F", "J", "M", "N", "R", "T"};
    private static boolean[] visited = new boolean[8];

    public int solution(int n, String[] conditions) {
        answer = 0;
        findPermutations(0, new String[8], conditions);
        return answer;
    }

    private static void findPermutations(int depth, String[] arrangement, String[] conditions) {
        if (depth == arrangement.length) {
            Map<String, Integer> positionMap = new HashMap<>();
            for (int i = 0; i < arrangement.length; i++) {
                positionMap.put(arrangement[i], i);
            }
            if (isValid(positionMap, conditions)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < characters.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arrangement[depth] = characters[i];
                findPermutations(depth + 1, arrangement, conditions);
                visited[i] = false;
            }
        }
    }

    private static boolean isValid(Map<String, Integer> positionMap, String[] conditions) {
        for (String condition : conditions) {
            String first = condition.substring(0, 1);
            String second = condition.substring(2, 3);
            char op = condition.charAt(3);
            int distance = condition.charAt(4) - '0';

            int actualDistance = Math.abs(positionMap.get(first) - positionMap.get(second)) - 1;

            if (!checkCondition(actualDistance, distance, op)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCondition(int actual, int required, char op) {
        switch (op) {
            case '=': return actual == required;
            case '<': return actual < required;
            case '>': return actual > required;
            default: return false;
        }
    }
}
