import java.util.*;

class Solution {
    public static int compare3(String word1, String target, String word2) {
        for (int i = 1; i <= target.length(); i++) {
            if (i == target.length()) {
                return target.length();
            }
            if (!target.substring(0, i).equals(word1.substring(0, Math.min(i, word1.length()))) &&
                !target.substring(0, i).equals(word2.substring(0, Math.min(i, word2.length())))) {
                return i;
            }
        }
        return target.length();
    }

    public static int compare2(String word1, String target) {
        for (int i = 1; i <= target.length(); i++) {
            if (i == target.length()) {
                return target.length();
            }
            if (!target.substring(0, i).equals(word1.substring(0, Math.min(i, word1.length())))) {
                return i;
            }
        }
        return target.length();
    }

    public static int solution(String[] words) {
        Arrays.sort(words);
        int answer = 0;

        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                answer += compare2(words[i + 1], words[i]);
            } else if (i == words.length - 1) {
                answer += compare2(words[i - 1], words[i]);
            } else {
                answer += compare3(words[i - 1], words[i], words[i + 1]);
            }
        }
        return answer;
    }
}