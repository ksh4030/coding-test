def solution(progresses, speeds):
    answer = []
    days = []

    # 각 기능이 배포되기까지 남은 날 수 계산
    for i in range(len(progresses)):
        day = (100 - progresses[i]) // speeds[i]
        if (100 - progresses[i]) % speeds[i] != 0:
            day += 1
        days.append(day)
    
    # 배포 가능한 기능의 개수를 세어줌
    max_day = days[0]
    count = 0
    
    for day in days:
        if day <= max_day:
            count += 1
        else:
            answer.append(count)
            count = 1
            max_day = day
    
    answer.append(count)
    
    return answer