def solution(n):
    answer = lcm(n, 6)
    return answer // 6

def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def lcm(a, b):
    return a * b // gcd(a, b)