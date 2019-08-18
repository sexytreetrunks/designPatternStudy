package IteratorPtn;

//집합체를 나타내는 인터페이스. Aggregate를 구현한 클래스는 배열이나 list처럼 무엇인가가 모여있는 변수를 가지고있음. iterator메소드는 얘를 구현한 클래스의 배열을 순차적으로 접근할수있는 iterator를 반환함
public interface Aggregate {
	//책의 경우 interface의 메소드에 abstract를 넣었지만 어짜피 interface의 메소드들은 기본 abstract이므로 안써도 무방
	public Iterator iterator();
}
