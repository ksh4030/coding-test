def solution(k, score):
    answer = []
    arr = []

    for i in range(len(score)) :
        arr.append(score[i])
        arr.sort()

        if len(arr) > k:
            arr.pop(0)  # 최솟값 제거

        answer.append(arr[0])  # 현재 최하위 점수 기록

    return answer
