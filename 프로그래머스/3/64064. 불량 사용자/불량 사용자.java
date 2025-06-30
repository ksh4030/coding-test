import java.util.*;

class Solution {
    Set<Set<String>> answerSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        boolean[] visited = new boolean[user_id.length];
        dfs(0, user_id, banned_id, visited, new HashSet<>());
        return answerSet.size();
    }

    void dfs(int depth, String[] user_id, String[] banned_id, boolean[] visited, Set<String> currentSet) {
        if (depth == banned_id.length) {
            // 조합을 복사하여 저장 (HashSet은 순서 상관 없이 동일한 요소면 중복 제거됨)
            answerSet.add(new HashSet<>(currentSet));
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) continue;
            if (!isMatch(user_id[i], banned_id[depth])) continue;

            visited[i] = true;
            currentSet.add(user_id[i]);

            dfs(depth + 1, user_id, banned_id, visited, currentSet);

            visited[i] = false;
            currentSet.remove(user_id[i]);
        }
    }

    boolean isMatch(String user, String ban) {
        if (user.length() != ban.length()) return false;

        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) == '*') continue;
            if (user.charAt(i) != ban.charAt(i)) return false;
        }

        return true;
    }
}
