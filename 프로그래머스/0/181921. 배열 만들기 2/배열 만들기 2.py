def solution(l, r):
    answer = []
    
    for i in range(l, r+1) :
        if isPossible(i) :
            answer.append(i)
    
    if len(answer) == 0 :
        return [-1]
    return answer

def isPossible(i) :
    for s in str(i) :
        if s != '0' and s != '5' :
            return False
    return True