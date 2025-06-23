def solution(s):
    answer = ''
    count_map = {}

    for i in s :
        count_map[i] = count_map.get(i, 0) + 1

    for i in s :
        if count_map[i] == 1 :
            answer += i

    return ''.join(sorted(answer))
