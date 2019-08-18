package IteratorPtn;

//Iterator를 실제로 구현한 클래스. Iterator를 구현한 클래스는 순차적으로 접근할 요소(배열)와 순차접근을위한 정보(index)를 가지고있어야함
public class BookShelfIterator implements Iterator<Book>{
	private BookShelf bookshelf;
	private int index;
	private int reverseIndex;
	
	public BookShelfIterator(BookShelf bookshelf) {
		this.bookshelf = bookshelf;
		this.index = 0;
		this.reverseIndex = bookshelf.getLength() -1;
	}
	
	@Override
	public boolean hasNext() {
		if(index < bookshelf.getLength())
			return true;
		else
			return false;
	}
	
	@Override
	public Book next() {
		if(hasNext())
			return bookshelf.getBookAt(index++);
		else
			return null;//나의경우 null을 리턴하게해주었지만 java.util에서 구현한 Iterator의 경우 NoSuchElementException을 호출하도록 구현되어있음
		// next메소드는 hasNext와 함께 사용되는게 바람직한동작이므로 내가 null값을 호출하도록 한 경우에는 코드를 abnormal하게 동작하도록 한 경우이므로 exception이 호출되도록한듯함
		// 암튼 그냥 hasNext처리없이 bookshelf에 있는 값을 리턴해도 됨
	}

	@Override
	public boolean hasPrevious() {
		if(reverseIndex > -1)
			return true;
		else
			return false;
	}

	@Override
	public Book previous() {
		return bookshelf.getBookAt(reverseIndex--);
	}

}
