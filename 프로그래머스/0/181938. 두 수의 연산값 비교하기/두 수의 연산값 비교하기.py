def solution(a, b):
    answer = 0
    
    n = int(str(a) + str(b))
    answer = max(n, 2*a*b)
    
    return answer