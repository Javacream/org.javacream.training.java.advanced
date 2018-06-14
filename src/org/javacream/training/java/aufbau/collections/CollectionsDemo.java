package org.javacream.training.java.aufbau.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Stream;

public class CollectionsDemo {

	public static void main(String[] args) {

		demoList();
		demoListWithBook();
		demoSet();
		demoSetWithBook();
		demoMap();
	}

	private static void demoList() {
		System.out.println("############## LIST ###############");
		ArrayList<String> names = new ArrayList<>();
		names.add("Hugo");
		names.add("Emil");
		names.add("Fritz");
		names.add("Hugo");
		System.out.println(names.size());
		System.out.println(names.get(0));
	}
	private static void demoListWithBook() {
		System.out.println("############## LIST WITH BOOK###############");
		ArrayList<Book> names = new ArrayList<>();
		names.add(new Book("ISBN1", "Hugo"));
		names.add(new Book("ISBN2", "Emil"));
		names.add(new Book("ISBN3", "Fritz"));
		names.add(new Book("ISBN1", "Hugo"));
		System.out.println(names.size());
		System.out.println(names.get(0));
	}
	private static void demoSetWithBook() {
		System.out.println("############## SET WITH BOOK###############");
		HashSet<Book> names = new HashSet<>();
		Book b1 = new Book("ISBN1", "Hugo");
		Book b2 = new Book("ISBN1", "Hugo");
		names.add(b1);
		names.add(new Book("ISBN2", "Emil"));
		names.add(new Book("ISBN3", "Fritz"));
		names.add(b2);
		System.out.println(names.size());
		//System.out.println(names.get(0));
	}

	static void demoListFunctional() {
		// Eine Liste enthält Elemente, identifiziert über einen Index
		// Mehrfache Einträge sind möglich
		ArrayList<String> names = new ArrayList<>();
		names.add("Hugo");
		names.add("Emil");
		names.add("Fritz");
		names.add("Hugo");
		System.out.println(names.size());
		// for (int i = 0; i < names.size(); i++) {
		// System.out.println(names.get(i));
		// }
		// for (String name: names) {
		// System.out.println(name);
		// }
		// Consumer<String> consumer = (String element) ->
		// {System.out.println(element);};
		// names.forEach((String element) -> {System.out.println(element);});
		names.forEach((element) -> System.out.println(element));

		// Die elemente der Liste names werden in eine neue Liste transformiert, wobei
		// die Elemente in Großbuchstaben umgewandelt werden.
		// Diese transformierte, neue Liste wird in eine neue Liste gefiltert, wobei als
		// Kriterium nur die Elemente aufgenommen werden, die mit "H" beginnen
		// Über diese letzte Liste wird iteriert und die ergebnisse auf die Konsole
		// geschrieben
		names.stream().map((element) -> element.toUpperCase()).filter((element) -> element.startsWith("H"))
				.forEach((element) -> System.out.println(element));

		Stream<String> start = names.stream();
		Stream<String> step1 = start.map((element) -> element.toUpperCase());
		Stream<String> step2 = step1.filter((element) -> element.startsWith("H"));
		step2.forEach((element) -> System.out.println(element));

		names.stream().map((element) -> element.toUpperCase()).filter((element) -> element.startsWith("H"))
				.map((e) -> new StringBuilder(e).reverse().toString())
				.forEach((element) -> System.out.println(element));

	}

	private static void demoMap() {
	}

	private static void demoSet() {
		System.out.println("############## SET ###############");
		HashSet<String> names = new HashSet<>(); 
		names.add("Hugo");
		names.add("Emil");
		names.add("Fritz");
		names.add("Hugo");
		System.out.println(names.size());
		//System.out.println(names.get(0));
	}

	static class Book{
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
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
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			return true;
		}
		private String isbn;
		private String title;
		@Override
		public String toString() {
			return "Book [isbn=" + isbn + ", title=" + title + "]";
		}
		public Book(String isbn, String title) {
			super();
			this.isbn = isbn;
			this.title = title;
		}
		
		
	}
}
