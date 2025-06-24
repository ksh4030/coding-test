def solution(myString, pat):
    tmp = ''
    
    for s in myString :
        if s == 'A' :
            tmp += 'B'
        else :
            tmp += 'A'
            
    return int(pat in tmp)