def solution(n, control):
    answer = 0
    
    for s in control :
        if s == 'w' :
            n += 1
        elif s == 's' :
            n -= 1
        elif s == 'd' :
            n += 10
        elif s == 'a' :
            n -= 10
    
    return n