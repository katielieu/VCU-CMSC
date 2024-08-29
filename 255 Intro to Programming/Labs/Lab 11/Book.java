package Labs.Lab11;

public class Book {
    private String title = "";
    private String author = "";

    /**
     * Default constructor that sets title to Test and author to null
     */
    public Book() {
        this.title = "Test";
        this.author = null;
    }

    /**
     * Parameterized constructor that sets the title and author to the given info
     * @param nTitle
     * @param nAuthor
     */
    public Book(String nTitle, String nAuthor) {
        title = nTitle;
        author = nAuthor;
    }

    /**
     * Set title to new title
     * @param newTitle
     */
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    /**
     * Set author to new author
     * @param newAuthor
     */
    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    /**
     * Return title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return author
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * returns the book's information
     * @return
     */
    public String toString() {
        return ("\"" + title + "\" " + "by " + author);
    }
}
