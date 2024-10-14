package cmsc256;

import java.util.Objects;

public class MyBook implements Comparable<MyBook> {
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String ISBN10;
    private String ISBN13;

    public MyBook() {
        title = "None Given";
        authorFirstName = "None Given";
        authorLastName = "None Given";
        ISBN10 = "0000000000";
        ISBN13 = "0000000000000";
    }

    public MyBook(String title, String authorFirstName, String authorLastName, String ISBN10, String ISBN13) {
        setTitle(title);
        setAuthorFirstName(authorFirstName);
        setAuthorLastName(authorLastName);
        setISBN10(ISBN10);
        setISBN13(ISBN13);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        if (authorFirstName == null) {
            throw new IllegalArgumentException("Author first name cannot be null");
        }
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        if (authorLastName == null) {
            throw new IllegalArgumentException("Author last name cannot be null");
        }
        this.authorLastName = authorLastName;
    }

    public String getISBN10() {
        return ISBN10;
    }

    public void setISBN10(String isbn10) {
        if (isbn10 == null) {
            throw new IllegalArgumentException("ISBN cannot be null");
        }

        if (isbn10.length() != 10 || !hasOnlyDigits(isbn10))
            throw new IllegalArgumentException("Invalid ISBN10");

        this.ISBN10 = isbn10;
    }

    public String getISBN13() {
        return ISBN13;
    }

    public void setISBN13(String isbn13) {
        if (isbn13 == null) {
            throw new IllegalArgumentException("ISBN cannot be null");
        }

        if (isbn13.length() != 13 || !hasOnlyDigits(isbn13))
            throw new IllegalArgumentException("Invalid ISBN13`");

        this.ISBN13 = isbn13;
    }

    private boolean hasOnlyDigits(String isbn) {
        for (int i = 0; i < isbn.length(); i++) {
            if(!Character.isDigit(isbn.charAt(i)))
                return false;
        }
        return true;
    }

    public String toString() {
        return  "Title: " + title + "\n" +
                "Author: " + authorFirstName + " " + authorLastName + "\n" +
                "ISBN10: " + ISBN10 + "\n" +
                "ISBN13: " + ISBN13;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyBook)) return false;
        MyBook MyBook = (MyBook) o;
        return Objects.equals(ISBN10, MyBook.ISBN10) && Objects.equals(ISBN13, MyBook.ISBN13);
    }

    public int hashCode() {
        return Objects.hash(ISBN10, ISBN13);
    }

    @Override
    public int compareTo(MyBook o) {
        int result = this.authorLastName.compareTo(o.getAuthorLastName());

        if (result == 0)
            result = this.authorFirstName.compareTo(o.getAuthorFirstName());

        if (result == 0)
            result = this.title.compareTo(o.getTitle());

        return result;
    }
}
