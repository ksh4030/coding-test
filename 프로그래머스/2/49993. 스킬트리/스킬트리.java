class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String s : skill_trees) {
            s = s.replaceAll("[^" + skill + "]", "");
            boolean flag = false;
            for (int i = 0; i < s.length(); i++) {
                if(skill.charAt(i) != s.charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }
        return answer;
    }
}