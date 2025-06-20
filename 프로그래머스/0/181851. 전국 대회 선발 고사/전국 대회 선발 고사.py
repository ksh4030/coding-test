def solution(rank, attendance):
    arr = []
    
    for i in range(len(rank)) :
        for j in range(len(rank)) :
            if i+1 == rank[j] and attendance[j] :
                if len(arr) == 3 :
                    break
                arr.append(j)

    return 10000*arr[0] + 100*arr[1] + arr[2]