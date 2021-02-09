package core.model;

import core.enumeration.Role;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Users {
    private final List<User> users;

    public Users(){
        this.users=new ArrayList<User>();
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void loadUsers() throws AccessDeniedException {
        this.users.add(new User(Role.BOOKSELLER));
        this.users.add(new User(Role.MEMBER,new Borrows()));
        this.users.get(1).getBorrows().addBorrow(
                new Borrow(new Book("Riviere a l'envers",
                        new Author("Jean-Claude Mourlevat")),new Date()),this.users.get(1));
        this.users.get(1).getBorrows().returnBook(new Book("Riviere a l'envers",
                new Author("Jean-Claude Mourlevat")));
        this.users.get(1).getBorrows().addBorrow(
                new Borrow(new Book("Riviere a l'endroit",
                        new Author("Jean-Claude Mourlevat")),new Date()),this.users.get(1));
        this.users.add(new User(Role.GUEST));
        this.users.add(new User(Role.GUEST));

    }

    public  void displayUsers(){
        for (User user:
             users) {
            user.displayUser();
        }
    }
}
