package core.model;

import java.nio.file.AccessDeniedException;

public class Library {
    Books books;
    Users users;

    public Library() throws AccessDeniedException {
        this.books=new Books();
        this.users=new Users();
        this.books.loadBooks();
        this.users.loadUsers();
        //this.users.displayUsers();
        //this.books.displayBooks();
    }

    public Users getUsers() {
        return users;
    }

    public Books getBooks() {
        return books;
    }
}
