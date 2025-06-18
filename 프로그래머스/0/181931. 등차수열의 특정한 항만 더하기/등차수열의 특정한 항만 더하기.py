def solution(a, d, included):
    answer = 0
    
    for b in included :
        if b :
            answer += a
        a += d
    
    return answer