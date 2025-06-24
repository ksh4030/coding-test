def solution(order):
    answer = 0
    
    for s in str(order) :
        if s != '0' and int(s) % 3 == 0 :
            answer += 1
    
    return answer