def solution(mats, park):
    rows = len(park)
    cols = len(park[0])

    # 큰 돗자리부터 시도
    for mat in sorted(mats, reverse=True):
        for i in range(rows - mat + 1):  # 돗자리가 안 넘치게
            for j in range(cols - mat + 1):
                flag = True
                for l in range(mat):
                    for m in range(mat):
                        if park[i + l][j + m] != "-1":
                            flag = False
                            break
                    if not flag:
                        break
                if flag:
                    return mat  # 가장 큰 돗자리를 찾았으므로 바로 리턴
    return -1
