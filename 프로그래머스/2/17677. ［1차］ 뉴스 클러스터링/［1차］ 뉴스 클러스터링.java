import java.util.ArrayList;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        ArrayList<String> g = new ArrayList<>();
        ArrayList<String> h = new ArrayList<>();
        

        for (int i = 0; i < str1.length()-1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i+1);
            if((ch1 >= 'a' && ch1 <= 'z') && (ch2 >= 'a' && ch2 <= 'z')) {
                list1.add(String.valueOf(ch1) + String.valueOf(ch2));
            }
        }

        for (int i = 0; i < str2.length()-1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i+1);
            if((ch1 >= 'a' && ch1 <= 'z') && (ch2 >= 'a' && ch2 <= 'z')) {
                list2.add(String.valueOf(ch1) + String.valueOf(ch2));
            }
        }

        for(String s : list1) {
            if(list2.remove(s)) {
                g.add(s);
            }
            h.add(s);
        }
        h.addAll(list2);
		

        double temp = (double)g.size() / (double)h.size();
        temp = temp * 65536;
        if(h.size()==0) {
            return 65536;
        }
        answer = (int)temp;
        
        return answer;
    }
}