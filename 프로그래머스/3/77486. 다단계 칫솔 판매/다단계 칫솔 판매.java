import java.util.*;

class Solution {

    static Map<String, String> parents = new HashMap<>();
    static Map<String, Integer> indexMap = new HashMap<>();
    static int[] answer;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        parents.clear();
        indexMap.clear();

        for (int i = 0; i < enroll.length; i++) {
            parents.put(enroll[i], referral[i]);
            indexMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            distribute(seller[i], amount[i] * 100);
        }

        return answer;
    }

    public void distribute(String person, int money) {

        while (!person.equals("-") && money > 0) {

            int give = money / 10;
            int mine = money - give;

            answer[indexMap.get(person)] += mine;

            person = parents.get(person);
            money = give;
        }
    }
}