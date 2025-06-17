def solution(my_string):
    answer = ''
    
    for s in my_string :
        if(s=='a' or s=='e' or s=='i' or s=='o' or s=='u') :
            continue
        answer += s
    
    return answer