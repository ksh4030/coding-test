from math import ceil

def solution(fees, records):
    dt = {}

    for rs in records:
        r = rs.split(' ')
        t = r[0].split(':')
        io = -1 if r[2] == 'IN' else 1
        dt[r[1]] = dt.get(r[1],0) + io*(int(t[0])*60 + int(t[1]))

    for k, v in dt.items():
        dt[k] = v + 23*60 + 59 if v <= 0 else v

    keys = sorted(dt.keys())

    return [fees[1] + ceil((dt[k]-fees[0])/fees[2])*fees[3]
            if dt[k] > fees[0] else fees[1] for k in keys]