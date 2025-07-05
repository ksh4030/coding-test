import java.util.*;

class Solution {
    static class Node {
        int x, y, index;
        Node left, right;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        public void insert(Node child) {
            if (child.x < this.x) {
                if (this.left == null) this.left = child;
                else this.left.insert(child);
            } else {
                if (this.right == null) this.right = child;
                else this.right.insert(child);
            }
        }
    }

    List<Integer> preorderList = new ArrayList<>();
    List<Integer> postorderList = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1); // index는 1부터 시작
        }

        // y 내림차순, x 오름차순 정렬
        Arrays.sort(nodes, (a, b) -> {
            if (a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });

        // 트리 구성
        Node root = nodes[0];
        for (int i = 1; i < n; i++) {
            root.insert(nodes[i]);
        }

        // 전위 순회
        preorder(root);
        // 후위 순회
        postorder(root);

        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }

        return answer;
    }

    public void preorder(Node node) {
        if (node == null) return;
        preorderList.add(node.index);
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        postorderList.add(node.index);
    }
}
