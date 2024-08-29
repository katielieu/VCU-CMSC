package Labs.Lab11;

import java.util.ArrayList;

public class Bookshelf {
    private int size;
    private ArrayList<Book> books;

    /**
     * Default constructor that sets size to 2 and initializes the ArrayList
     */
    public Bookshelf() {
        size = 2;
        books = new ArrayList<>();
    }

    /**
     * Parameterized constructor that sets the size to the given size and initializes the ArrayList
     * @param size
     */
    public Bookshelf(int size) {
        this.size = size;
        books = new ArrayList<>();
    }

    /**
     * Return the size of the bookshelf
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Return the books on the bookshelf
     * @return books
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Add a book to the shelf if it is not full
     * @param book
     */
    public void addBook(Book book) {
        if (books.size() < size) {
            books.add(book);
        }
    }

    /**
     * Remove the first book on the shelf if it is not empty
     * @return the removed book or null if empty
     */
    public Book removeBook() {
        if(!books.isEmpty()) {
            return books.remove(0);
        } else {
            return null;
        }
    }

    /**
     * Clear the bookshelf of all books
     */
    public void emptyBookshelf() {
        books.clear();
    }
}
