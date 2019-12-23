# Composite pattern

## Composite 패턴이란?
파일시스템의 directory는 file 혹은 또다른 directory를 가질수있음. file과 directory는 서로 다르지만 directory entry라고 하여 같은 것으로 간주(동일시)함. directory는 자기 안에 directory를 가질수있으므로 재귀적인 구조를 만들수 있음.  이렇게 그릇(directory)과 내용물(file)을 동일시해서 재귀적인 구조를 만들기위한 디자인 패턴을 composite패턴이라함

## composite 패턴의 구성
- Leaf: 내용물을 표시하는 역할. 내부에 다른것을 넣을수 없음. File클래스에 해당
- Composite: 그릇을 나타내는 역할. Leaf나 composite역할을 넣을수 있음. Directroy클래스에 해당
- Component: leaf역할과 composite역할을 동일시하는 역할을 담당. Entry클래스
- Client: composite패턴의 사용자.

## composite패턴은 어떨때 사용될까?
디렉토리안의 디렉토리처럼 재귀적인 구조를 가지면 composite패턴이 사용될수있음
트리구조로 된 데이터패턴도 composite패턴에 해당  
html의 태그구조가 composite패턴이 적용될수있음 (태그안에 태그가 들어갈수있으므로)


