def solution(lines):
    answer = 0
    arr = [0] * 201
    
    for a in lines :
        for i in range(a[0], a[1]) :
            arr[i+100] += 1
    
    for i in arr :
        if i > 1 :
            answer += 1
    
    return answer