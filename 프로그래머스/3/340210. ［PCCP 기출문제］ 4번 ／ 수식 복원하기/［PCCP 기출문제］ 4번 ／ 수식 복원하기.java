import java.util.*;
//X인거도 같이 루프 돌린다음에 가장 arr배열에서 가운트가 가장 많이 된걸 기준으로 하면 되겠네
class Solution {
    public String[] solution(String[] expressions) {
        int[] arr = new int[10];
        int cnt = 0;
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<expressions.length; i++) {
            String[] bucket = expressions[i].split(" ");
            if(bucket[4].equals("X")) {
                list.add(expressions[i]);
                continue;
            }
            for(int j=2; j<=9; j++) {
                try {
                    int num1 = Integer.parseInt(bucket[0], j);
                    int num2 = Integer.parseInt(bucket[2], j);
                    int result = Integer.parseInt(bucket[4], j);
                    if(bucket[1].equals("+")) {
                        if(num1 + num2 == result) {
                            arr[j]++;
                        }
                    } else {
                        if(num1 - num2 == result) {
                            arr[j]++;
                        }
                    }
                } catch (Exception e) {
                        continue;
                }
            }
            cnt++;
        }
        
        for(int i=0; i<list.size(); i++) {
            String[] bucket = list.get(i).split(" ");
            
            for(int j=2; j<=9; j++) {
                try {
                    int num1 = Integer.parseInt(bucket[0], j);
                    int num2 = Integer.parseInt(bucket[2], j);
                    arr[j]++;
                } catch (Exception e) {
                    continue;
                }
            }
        }
        
        int max = Arrays.stream(arr).max().orElseThrow();
        
        // System.out.println(Arrays.toString(arr));
        // System.out.println(cnt);
        
        String[] answer = new String[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            String[] bucket = list.get(i).split(" ");
            Set<String> set = new HashSet<>();            
            for(int j=2; j<=9; j++) {
                if(max == arr[j]) {
                    try {
                        int num1 = Integer.parseInt(bucket[0], j);
                        int num2 = Integer.parseInt(bucket[2], j);
                        int result = bucket[1].equals("+") ? num1 + num2 : num1 - num2;
                        set.add(Integer.toString(result, j));
                    } catch (Exception e) {
                        continue;
                    }                    
                }
            }
            if(set.size() == 1) {
                String s = list.get(i).substring(0, list.get(i).length()-1);
                answer[i] = s + set.iterator().next();
            } else {
                String s = list.get(i).substring(0, list.get(i).length()-1);
                answer[i] = s + "?";
            }
        }
        
        return answer;
    }
}