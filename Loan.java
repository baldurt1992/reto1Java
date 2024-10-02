package library;

import java.util.Date;

public class Loan {
    private Book book;
    private User user;
    private Date loanDate;
    private Date returnDate;

    public Loan(Book book, User user, Date loanDate, Date returnDate) {
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan: " + book.getTitle() + " borrowed by " + user.getName() + " from " + loanDate + " to " + returnDate;
    }
}
