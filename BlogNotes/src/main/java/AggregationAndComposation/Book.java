package AggregationAndComposation;

public class Book {
	private String title;
	private String author;

	Book(String title, String author) {

		this.setTitle(title);
		this.setAuthor(author);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
