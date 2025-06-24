def solution(arr, queries):
    answer = []
    
    for a in queries :
        for i in range(a[0], a[1]+1) :
            arr[i] += 1
    
    return arr