def finalanswer(li1, li2):
    # li2를 집합으로 변환하여 빠른 검색을 가능하게 합니다.
    set_li1 = set(li1)

    # 결과를 저장할 리스트 생성
    li3 = []

    # li1의 각 요소를 순회
    for item in li2:
        # item이 set_li2에 존재하면 1, 그렇지 않으면 0을 추가합니다.
        if item in set_li1:
            li3.append(1)
        else:
            li3.append(0)

    return li3

# 첫 번째로 정수의 개수를 입력받기
F = int(input())

# 정수를 공백으로 구분하여 입력받기
Fnum = input()

# 입력된 문자열을 공백으로 나누어 리스트로 변환
li1 = list(map(int, Fnum.split()))

# 검수받을 수 갯수
R = int(input())

# 정수를 공백으로 구분하여 입력받기
Rnum = input()

li2 = list(map(int, Rnum.split()))

# 결과를 리스트로 얻기
result = finalanswer(li1, li2)

# 결과 리스트를 엔터로 구분하여 출력
for item in result:
    print(item)
