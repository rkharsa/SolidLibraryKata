package core.model;

import core.enumeration.Role;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

public class Books {
    private final List<Book> books;

    public Books(){
        this.books=new ArrayList<>();
    }

    public void loadBooks() throws AccessDeniedException {
        addBook(new Book("Riviere a l'envers",new Author("Jean-Claude Mourlevat")),new User(Role.BOOKSELLER));
        addBook(new Book("Clean code",new Author("Robert ")),new User(Role.BOOKSELLER));


    }

    public void addBook(Book book,User user) throws AccessDeniedException {
        if(!user.getRole().equals(Role.BOOKSELLER))
            throw new AccessDeniedException("Only Bookseller can add book");
        this.books.add(book);
    }

    public void displayBooks(){
        for (Book book:
             books) {
                book.display();
        }
    }

}
