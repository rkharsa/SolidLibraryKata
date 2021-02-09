import core.enumeration.Role;
import core.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.nio.file.AccessDeniedException;

import java.util.Date;

public class BorrowsTest {
    Borrows borrows;
    @Before
    public void initializer() throws Exception {
        borrows=new Borrows();
    }
    @Test
    public void testAddBorrowWithMember() throws AccessDeniedException {
        int expected=2;
        borrows.addBorrow(new Borrow(new Book("tITRE 1",
                new Author("Rani")),
                new Date()),new User(Role.MEMBER));
        borrows.addBorrow(new Borrow(new Book("tITRE 1",
                new Author("Rani")),
                new Date()),new User(Role.MEMBER));
        int size=borrows.getBorrows().size();
        Assert.assertEquals("Size should be 2",expected,size);
    }
    @Test(expected = AccessDeniedException.class)
    public void testAddBorrowWithGuest() throws AccessDeniedException {
        borrows.addBorrow(new Borrow(new Book("tITRE 1",
                new Author("Rani")),
                new Date()),new User(Role.GUEST));
    }

    @Test(expected = AccessDeniedException.class)
    public void testAddBorrowWithBookseller() throws AccessDeniedException {
        borrows.addBorrow(new Borrow(new Book("tITRE 1",
                new Author("Rani")),
                new Date()),new User(Role.BOOKSELLER));
    }

    @Test(expected = AccessDeniedException.class)
    public void testBorrowMoreThan3Books() throws AccessDeniedException {
        borrows.addBorrow(new Borrow(new Book("tITRE 1",
                new Author("Rani")),
                new Date()),new User(Role.MEMBER));
        borrows.addBorrow(new Borrow(new Book("tITRE 1",
                new Author("Rani")),
                new Date()),new User(Role.MEMBER));
        borrows.addBorrow(new Borrow(new Book("tITRE 1",
                new Author("Rani")),
                new Date()),new User(Role.MEMBER));
        borrows.addBorrow(new Borrow(new Book("tITRE 1",
                new Author("Rani")),
                new Date()),new User(Role.MEMBER));
    }

    @Test
    public void testReturnBook() throws AccessDeniedException {
       int expected =2;
       int size;
        borrows.addBorrow(new Borrow(new Book("tITRE 1",
                new Author("Rani")),
                new Date()),new User(Role.MEMBER));
        borrows.addBorrow(new Borrow(new Book("tITRE 2",
                new Author("Rani")),
                new Date()),new User(Role.MEMBER));
        borrows.addBorrow(new Borrow(new Book("tITRE 3",
                new Author("Rani")),
                new Date()),new User(Role.MEMBER));

        borrows.returnBook(new Book("tITRE 3",
                new Author("Rani")));
        size=borrows.getBorrows().size();
        Assert.assertEquals("should be equal to 2", expected,size);

    }


}
