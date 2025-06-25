def solution(babbling):
    answer = 0
    
    for s in babbling :
        if isPossible(s) :
            answer += 1
    
    return answer

def isPossible(s) :
    target = ["aya", "ye", "woo", "ma"]
    
    for i in target :
        if i in s :
            s = s.replace(i, " ")
    
    s = s.replace(" ", "")
    return s == ""
    
    