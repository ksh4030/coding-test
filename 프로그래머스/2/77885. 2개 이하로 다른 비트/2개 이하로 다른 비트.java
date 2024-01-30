class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }
            String s = Long.toString(numbers[i], 2);
            int idx = s.lastIndexOf("0");
            s = idx == -1 ? s = "10" + s.substring(1) : s.substring(0, idx) + "10" + s.substring(idx+2);
            answer[i] = Long.parseLong(s, 2);
        }
        return answer;
    }
}