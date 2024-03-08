import java.util.*;
class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        int dayForM = 28;
        // 오늘 일자의 년 월 일 int 화
        int todayY = Integer.parseInt(today.substring(0,4));
        int todayM = Integer.parseInt(today.substring(5,7));
        int todayD = Integer.parseInt(today.substring(8,10));
        
        // 0년0월0일부터 오늘까지의 일수 -> 1년 의 일수 + 1달의 일수 + 일수
        int totalDay = ( todayY * dayForM * 12 ) + ( todayM * 28 ) + todayD;
        
        // 정답 배열
        List<Integer> answer = new ArrayList<>();
        // terms privacies 에서 매칭 되는 유효 기간을 갖고 오기위해 hashmap 사용
        HashMap<Character , Integer> termsMap = new HashMap<>();
        
        // hashmap에 데이터 삽입
        // key : 약관 종류
        // value : 유효 기간
        for(String term : terms ){
            char term0 = term.charAt(0);
            int termM = Integer.parseInt(term.substring(2));
            termsMap.put( term0 , termM );
        }
        
        // 각 privacies 요소들 비교
        for( int i = 0 ; i < privacies.length ; i++ ){
            // 약관 종류 변수 선언
            char privacy0 = privacies[i].charAt(11);
            // ~ privacyYMD 에 대한 일자 계산
            int privacyY = Integer.parseInt(privacies[i].substring(0,4));
            int privacyM = Integer.parseInt(privacies[i].substring(5,7));
            int privacyD = Integer.parseInt(privacies[i].substring(8,10));
            int totalPrivacyDay = ( privacyY * 12 * dayForM ) + ( privacyM * dayForM ) + privacyD;
            // 약관 종류에 다른 유효 기간에 대한 일자 계산
            int termM = termsMap.get(privacy0);
            int termDay = termM * dayForM;
            // 계산된 값들 비교
            if( totalPrivacyDay + termDay <= totalDay ) {
                answer.add(i+1);
            }
            
        }
        
        
        return answer;
    }
}