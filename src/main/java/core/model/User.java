package core.model;

import core.enumeration.Role;

import java.util.UUID;

public class User {
    private final UUID idUser;
    private final Role role;
    private final Borrows borrows;

    public User(Role role, Borrows borrows) {
        this.idUser = UUID.randomUUID();;
        this.role=role;
        this.borrows = borrows;
    }

    public User(Role role) {
        this.idUser = UUID.randomUUID();;
        this.role=role;
        this.borrows = new Borrows();
    }

    public Role getRole() {
        return role;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public Borrows getBorrows() {
        return borrows;
    }

    public void displayUser(){
        System.out.println("idUser "+this.getIdUser()+" Role :"+this.getRole()+" \nBorrows ");
        this.getBorrows().displayBorrows();
        System.out.println("\n");
    }
}