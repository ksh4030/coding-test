import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1.split("[0-9]")[0];
                String b = o2.split("[0-9]")[0];

                int result = a.toLowerCase().compareTo(b.toLowerCase());
                if(result == 0) result = checkNum(o1, a) - checkNum(o2, b);
                return result;
            }
        });
        return files;
    }
    
    static public int checkNum(String str, String head) {
        str = str.substring(head.length());
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) && result.length() < 5) result += c;
            else break;
        }
        return Integer.valueOf(result);
    }
}