package IteratorPtn;

//집합체(배열이나 리스트)를 하나씩 접근하면서 검색을 실행하는 인터페이스
public interface Iterator<T> {
	public boolean hasNext();
	public T next(); 
	//public Object next(); <- 책은 리턴타입을 유연하게 정의하기위해 Object를 이용했지만 나의 경우 제네릭타입을 이용함
}
