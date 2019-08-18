package IteratorPtn;

import java.util.Vector;

public class BookShelf implements Aggregate{
	private Vector<Book> books;
	//private Book[] books;
	private int last = 0;
	
	public BookShelf() {
		books = new Vector<>();
	}
	
	//책에서 구현한 생성자. 임의로크기를 지정하는것보다 이렇게 생성시 크기를 지정해주는게 좀더 유연쓰
	public BookShelf(int maxsize) {
		books = new Vector<>(maxsize);
	}

	public Book getBookAt(int idx) {
		if(idx <0 || idx > getLength())
			return null;
		else
			return books.elementAt(idx);
	}
	
	public void appendBook(Book book) {
		books.add(book);
		last++;
	}
	
	public int getLength() {
		//return books.length;
		return last;//현재 배열에 차있는 원소들의 개수를 알기위한 메소드이므로 last를 리턴해주어야함. length는 배열의 전체크기를 나타낼뿐 저장된 원소의수를 나타내지않는다는점을 기억하자
	}
	
	@Override
	public Iterator<Book> iterator() {
		return (new BookShelfIterator(this));
	}
}
