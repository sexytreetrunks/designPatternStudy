package IteratorPtn;

public class BookShelfReverseIterator implements ReverseIterator<Book>{
	private BookShelf bookshelf;
	private int reverseIndex;
	
	public BookShelfReverseIterator(BookShelf bookshelf) {
		this.bookshelf = bookshelf;
		this.reverseIndex = bookshelf.getLength() -1;
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
