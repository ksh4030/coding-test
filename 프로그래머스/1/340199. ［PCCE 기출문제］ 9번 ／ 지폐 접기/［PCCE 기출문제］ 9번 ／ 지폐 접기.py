def solution(wallet, bill):
    answer = 0
    
    x = wallet[0]
    y = wallet[1]
    a = bill[0]
    b = bill[1]
    
    while True :
        if(x >= a and y >=b) or (x >= b and y >= a) :
            break
        
        if a > b :
            a //= 2
        else :
            b //= 2
        
        answer += 1
            
    
    return answer