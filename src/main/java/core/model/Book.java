package core.model;

public class Book {
    private final String title ;
    private final Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void display(){
        System.out.println("Title : "+ this.title);
        author.display();
        System.out.println();
    }
}
