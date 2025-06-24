def solution(arr, queries):
    answer = []
    
    for a in queries :
        tmp = arr[a[0]]
        arr[a[0]] = arr[a[1]]
        arr[a[1]] = tmp
    
    return arr