import core.enumeration.Role;
import core.model.Author;
import core.model.Book;
import core.model.Books;
import core.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.AccessDeniedException;


public class BooksTest {
    Books books;
    @Before
    public void initializer(){
        books= new Books();
    }

    @Test
    public void testAddBookWithBookSeller() throws AccessDeniedException {
        int expected=1;
        this.books.addBook(new Book("Titre",new Author("Rani")),new User(Role.BOOKSELLER));
        Assert.assertEquals("Should be equal to 1 ",expected,this.books.getBooks().size());
    }

    @Test(expected = AccessDeniedException.class)
    public void testAddBookWithGuest() throws AccessDeniedException {
        this.books.addBook(new Book("Titre",new Author("Rani")),new User(Role.GUEST));
    }

    @Test(expected = AccessDeniedException.class)
    public void testAddBookWithMember() throws AccessDeniedException {
        this.books.addBook(new Book("Titre",new Author("Rani")),new User(Role.MEMBER));
    }

}
