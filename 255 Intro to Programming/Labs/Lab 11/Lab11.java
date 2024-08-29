package Labs.Lab11;

public class Lab11 {
    public static void main(String[] args) {
        Book book1 = new Book("Atomic Habits", "James Clear");
        Book book2 = new Book("Animal Farm", "George Orwell");
        Book book3 = new Book("The Silent Patient", "Alex Michaelides");

        //print the books
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString() + "\n");

        //create Bookshelf object
        Bookshelf myBookshelf = new Bookshelf(3);

        //add the books to the bookshelf
        myBookshelf.addBook(book1);
        myBookshelf.addBook(book2);
        myBookshelf.addBook(book3);

        //print each book in the bookshelf
        System.out.println("My Bookshelf:");
        for(Book book : myBookshelf.getBooks()) {
            System.out.println(book);
        }
        System.out.println();

        //empty out the bookshelf
        myBookshelf.emptyBookshelf();

        //redisplay the bookshelf
        System.out.println("My Bookshelf:");
        for(Book book : myBookshelf.getBooks()) {
            System.out.println(book);
        }
    }
}
