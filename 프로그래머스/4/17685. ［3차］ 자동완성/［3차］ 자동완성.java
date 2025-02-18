import java.util.*;

class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;  // 해당 노드를 지나간 단어의 개수
    }

    static class Trie {
        TrieNode root = new TrieNode();

        // 단어 삽입
        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
                node.count++;  // 현재 노드를 지나간 단어의 개수 증가
            }
        }

        // 단어를 입력할 때 몇 글자까지 입력해야 하는지 계산
        int getTypingCount(String word) {
            TrieNode node = root;
            int typingCount = 0;
            for (char c : word.toCharArray()) {
                node = node.children.get(c);
                typingCount++;
                if (node.count == 1) break;  // 단어가 유일해지는 순간 종료
            }
            return typingCount;
        }
    }

    public int solution(String[] words) {
        Trie trie = new Trie();
        int answer = 0;

        // Trie에 단어 삽입
        for (String word : words) {
            trie.insert(word);
        }

        // 각 단어가 몇 글자까지 입력해야 하는지 계산
        for (String word : words) {
            answer += trie.getTypingCount(word);
        }

        return answer;
    }
}
