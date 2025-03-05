import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            if (isPossible(schedules[i], timelogs[i], startday)) answer++;
        }

        return answer;
    }

    public boolean isPossible(int standard, int[] day, int startday) {
        for (int i = 0; i < 7; i++) {
            if (startday == 6 || startday == 7) { 
                startday++; // 주말 건너뛰기
                if (startday > 7) startday = 1;
                continue;
            }

            // 출근 인정 시각 계산
            int hour = standard / 100;
            int min = standard % 100 + 10;

            if (min >= 60) {
                hour++;
                min -= 60;
            }

            // 두 자리 분(min)을 보장하기 위해 포맷팅
            int allowedTime = hour * 100 + min;

            // 지각 여부 확인
            if (day[i] > allowedTime) return false;

            // 요일 증가
            startday++;
            if (startday > 7) startday = 1;
        }
        return true;
    }
}
