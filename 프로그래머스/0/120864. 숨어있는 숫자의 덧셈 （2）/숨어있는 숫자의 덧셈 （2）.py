import re

def solution(my_string):
    answer = 0
    
    my_string = re.sub(r"[a-zA-Z]", " ", my_string)
    arr = my_string.split(" ")
    
    for i in arr :
        if i != '' :
            answer += int(i)
    
    return answer