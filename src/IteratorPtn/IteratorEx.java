package IteratorPtn;

public class IteratorEx {
	public static void main(String[] args) {
		BookShelf bookshelf = new BookShelf();
		bookshelf.appendBook(new Book("이거시 자바닷"));
		bookshelf.appendBook(new Book("이거시 디자인패턴이닷"));
		bookshelf.appendBook(new Book("이거시 진리닷"));
		bookshelf.appendBook(new Book("인생의 진리닷"));
		
		Iterator<Book> iterator = bookshelf.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
	}
}
