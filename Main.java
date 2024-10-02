package library;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try ( 
                Scanner scanner = new Scanner(System.in)) {
            OUTER:
            while (true) {
                System.out.println("==== Library Loan Menu ====");
                System.out.println("1. Create a new loan");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                            Loan loan = createLoan(scanner); 
                        System.out.println(loan.toString());
                        loan.getBook().setBorrowed(true);
                        System.out.println("The book '" + loan.getBook().getTitle() + "' is borrowed: " + loan.getBook().isBorrowed());
                    }
                    case 2 -> {
                        System.out.println("Exiting the program.");
                        break OUTER;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    public static Loan createLoan(Scanner scanner) {
        scanner.nextLine();

        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the book ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, isbn);

        System.out.print("Enter the user's name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter the user's ID: ");
        String userId = scanner.nextLine();

        User user = new User(userName, userId);

        Date loanDate = new Date();
        int DAYS_IN_MILISECONDS = 7 * 24 * 60 * 60 * 1000;
        Date returnDate = new Date(loanDate.getTime() + DAYS_IN_MILISECONDS ); 

        return new Loan(book, user, loanDate, returnDate);

        /* Book book1 = new Book("Don Quixote", "Miguel de Cervantes", "978-84-670-3536-3");
         System.out.println(book1); */
    }
}
