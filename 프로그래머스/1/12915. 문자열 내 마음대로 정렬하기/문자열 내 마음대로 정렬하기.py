def solution(strings, n):
    answer = []
    strings.sort()  # 사전순 정렬 먼저

    for s in strings:
        if len(answer) == 0:
            answer.append(s)
        else:
            flag = False
            for i in range(len(answer)):
                if answer[i][n] > s[n]:  # n번째 문자 비교
                    answer.insert(i, s)  # i에 삽입해야 함
                    flag = True
                    break
            if not flag:
                answer.append(s)

    return answer
