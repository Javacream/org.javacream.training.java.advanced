package org.javacream.training.java.aufbau;

public class Book {

	private String isbn;
	private String title;
	private Integer pages;
	private Double price;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", pages=" + pages + ", price=" + price + "]";
	}
	public Book(String isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
}
