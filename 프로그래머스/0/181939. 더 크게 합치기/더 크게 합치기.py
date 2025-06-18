def solution(a, b):
    answer = 0
    x = int(str(a) + str(b))
    y = int(str(b) + str(a))
    
    if x > y :
        return x
    else :
        return y
    
    return answer