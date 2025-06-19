def solution(polynomial):
    arr = polynomial.split()
    
    x = 0
    num = 0
    
    for s in arr:
        if 'x' in s:
            if s == 'x':
                x += 1
            else:
                x += int(s.replace('x', ''))
        elif s == '+':
            continue
        else:
            num += int(s)
    
    if x == 0 and num == 0:
        return '0'
    elif x == 0:
        return str(num)
    elif num == 0:
        return "x" if x == 1 else str(x) + "x"
    else:
        return ("x" if x == 1 else str(x) + "x") + " + " + str(num)
