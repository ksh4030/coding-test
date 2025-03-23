import java.util.*;

class Solution {
    static Map<String, String> myParent = new HashMap<>();
    static Map<String, Integer> money = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        init(enroll, referral);

        for (int i = 0; i < seller.length; i++) {
            distribute(seller[i], amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = money.get(enroll[i]);
        }

        return answer;
    }

    // 판매 수익 분배 - 재귀 방식
    public void distribute(String name, int income) {
        if (name.equals("-") || income < 1) return;

        int commission = income / 10;
        int myShare = income - commission;

        money.put(name, money.getOrDefault(name, 0) + myShare);
        distribute(myParent.get(name), commission);
    }

    // 부모 관계 및 초기화
    public void init(String[] enroll, String[] referral) {
        for (int i = 0; i < enroll.length; i++) {
            myParent.put(enroll[i], referral[i]);
            money.put(enroll[i], 0);
        }
    }
}
