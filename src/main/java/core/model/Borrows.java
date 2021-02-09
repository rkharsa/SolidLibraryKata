package core.model;

import core.enumeration.Role;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

public class Borrows {
    private final List<Borrow> borrows;

    public Borrows() {
        this.borrows =new ArrayList<>();
    }

    public boolean canBorrow(User user){
        return borrows.size() != 3 && user.getRole().equals(Role.MEMBER);
    }

    public void addBorrow(Borrow borrow,User user) throws AccessDeniedException {
        if(!canBorrow(user))
            throw new AccessDeniedException("Only Member can borrow and 3 books borrows maximum");
        this.borrows.add(borrow);

    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void returnBook(Book book){
        int increm=0;
       for (Borrow borrow:
             borrows) {
            Book borrowBook=borrow.getBook();
            if(borrowBook.getTitle().equals(book.getTitle())
                    && borrowBook.getAuthor().getName().equals(book.getAuthor().getName())){
                this.borrows.remove(increm);
                break;
            }
            increm++;

        }
    }

    public void displayBorrows(){
        for (Borrow borrow:
            borrows ) {
            System.out.println("Date : "+ borrow.getDate()+" Number of weeks : "+borrow.numberOfWeeks()+ " Title : "+ borrow.getBook().getTitle()+" Author :"+borrow.getBook().getAuthor().getName()) ;
        }
    }
}
