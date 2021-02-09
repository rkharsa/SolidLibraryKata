package cli;

import core.enumeration.Role;
import core.model.*;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws AccessDeniedException {
        Library library=new Library();
        boolean stop =true;
        while (stop) {
            stop = firstMenu(library, stop);
        }
    }

    private static boolean firstMenu(Library library, boolean stop) {
        boolean disconnect;
        System.out.println("taper 1 : Choisir l'utilisateur ");
        System.out.println("taper 2 : Ajouter un utilisateur");
        Scanner chooseCommand = new Scanner(System.in);
        switch (chooseCommand.nextInt()) {
            case 1 -> {
                System.out.println("Liste des utilisateurs");
                library.getUsers().displayUsers();

                Scanner userScan = new Scanner(System.in);
                int size = library.getUsers().getUsers().size();
                System.out.println("Choisir l'utilisateur entre 0 et "+ size);
                int userChoose=userScan.nextInt();
                if (userChoose <= size && userChoose>= 0) {
                    User user = library.getUsers().getUsers().get(userChoose);
                    disconnect = true;
                    while (disconnect) {
                        Scanner command = getMenu();
                        disconnect = secondMenu(library, disconnect, user, command);
                    }
                }
            }
            case 2 -> addUser(library);
            case 3-> stop =false;
        }
        return stop;
    }


    private static boolean secondMenu(Library library, boolean disconnect, User user, Scanner command) {
        switch (command.nextInt()) {
            case 1 -> library.getBooks().displayBooks();
            case 2 -> user.getBorrows().displayBorrows();
            case 3 -> library.getUsers().displayUsers();
            case 4 -> user.displayUser();
            case 5 -> addBorrow(user);
            case 6 -> returnBook(user);
            case 7 -> disconnect = false;
        }
        return disconnect;
    }

    private static Scanner getMenu() {
        System.out.println("taper 1 : Liste des livres");
        System.out.println("taper 2 : Liste des emprunts");
        System.out.println("taper 3 : Liste des users ");
        System.out.println("taper 4:  profil");
        System.out.println("taper 5:  emprunter un livre");
        System.out.println("taper 6:  retourner un livre");
        System.out.println("taper 7 : se déconnecter ");

        return new Scanner(System.in);
    }

    private static void returnBook(User user) {
        System.out.println("Entrer le titre");
        Scanner title = new Scanner(System.in);
        System.out.println("Entrer nom de l'auteur");
        Scanner name = new Scanner(System.in);
        user.getBorrows().returnBook(new Book(title.next(), new Author(name.next())));
    }

    private static void addBorrow(User user) {
        try {
            System.out.println("Entrer le titre");
            Scanner title = new Scanner(System.in);
            System.out.println("Entrer nom de l'auteur");
            Scanner name = new Scanner(System.in);
            user.getBorrows().addBorrow(new Borrow(new Book(title.next(), new Author(name.next())), new Date()), user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addUser(Library library) {
        System.out.println("Choisir le role");
        System.out.println("taper 1 : BOOKSELLER");
        System.out.println("taper 2 : GUEST");
        System.out.println("taper 3 : MEMBER");
        Role role;
        Scanner chooseRole=new Scanner(System.in);
        role = switch (chooseRole.nextInt()) {
            case 1 -> Role.BOOKSELLER;
            case 2 -> Role.GUEST;
            case 3 -> Role.MEMBER;
            default -> throw new IllegalStateException("Unexpected value: " + chooseRole.nextInt());
        };
        library.getUsers().getUsers().add(new User(role));
    }
}
