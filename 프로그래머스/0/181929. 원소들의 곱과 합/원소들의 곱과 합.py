def solution(num_list):
    answer = 0
    a = 0
    b = 1
    
    for num in num_list :
        a += num
        b *= num
    
    if(a*a > b) :
        return 1
    else :
        return 0
    
    return answer