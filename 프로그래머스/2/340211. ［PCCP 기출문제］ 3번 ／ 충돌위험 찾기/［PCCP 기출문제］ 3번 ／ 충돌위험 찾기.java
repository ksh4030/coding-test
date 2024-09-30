import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static class Pos {
        public int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static class Robot {
        public Pos pos;
        public List<Pos> posList;

        public Robot(Pos pos) {
            this.pos = pos;
            posList = new ArrayList<>();
        }

        public boolean movePos(int[][] intArrays) {
            if (posList.size() > 0 && posList.get(0).y == pos.y && posList.get(0).x == pos.x) {
                posList.remove(0);
            }

            // 기존 위치 삭제
            intArrays[pos.y][pos.x]--;

            if (posList.size() == 0) {
                return false;
            }

            // 위치 갱신 및 추가
            if (posList.get(0).y != pos.y) {
                if (posList.get(0).y > pos.y) {
                    pos.y++;
                } else {
                    pos.y--;
                }
            } else if (posList.get(0).x != pos.x) {
                if (posList.get(0).x > pos.x) {
                    pos.x++;
                } else {
                    pos.x--;
                }
            }

            intArrays[pos.y][pos.x]++;
            return true;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int[][] intArrays = new int[101][101]; // 이동 가능 좌표 배열

        // Robot List 세팅, 출발 위치 세팅
        List<Robot> list = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            int index = routes[i][0] - 1;
            Pos pos = new Pos(points[index][0], points[index][1]);
            Robot robot = new Robot(pos);

            intArrays[pos.y][pos.x]++;

            for (int j = 1; j < routes[i].length; j++) {
                index = routes[i][j] - 1;
                pos = new Pos(points[index][0], points[index][1]);
                robot.posList.add(pos);
            }

            list.add(robot);
        }

        // 중복 위치 확인
        for (int[] row : intArrays) {
            for (int val : row) {
                if (val > 1) {
                    answer++;
                }
            }
        }

        while (list.size() > 1) {
            // 위치 갱신
            List<Integer> removeList = new ArrayList<>();
            for (int i = list.size() - 1; i >= 0; i--) {
                boolean b = list.get(i).movePos(intArrays);

                if (!b) {
                    removeList.add(i);
                }
            }

            // 이동이 완료된 로봇 제거
            for (int idx : removeList) {
                list.remove(idx);
            }

            // 중복 위치 확인
            for (int[] row : intArrays) {
                for (int val : row) {
                    if (val > 1) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    // public static void main(String[] args) {
    //     Solution sol = new Solution();
    //     int[][] points = {{1, 1}, {2, 2}, {3, 3}};
    //     int[][] routes = {{1, 2, 3}, {3, 2, 1}};
    //     System.out.println(sol.solution(points, routes));  // 테스트 실행
    // }
}
