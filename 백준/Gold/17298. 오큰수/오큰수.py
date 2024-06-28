import sys
input = sys.stdin.readline

N = int(input())
num = list(map(int, input().split()))

stack = []
result = [-1] * N

stack.append(0)
for i in range(1, N):
    while stack and num[stack[-1]] < num[i]:
        result[stack.pop()] = num[i]
    stack.append(i)

for i in result:
    print(i, end=' ')
