package core.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Borrow {
    private final Book book;
    private final Date date ;

    public Borrow(Book book, Date date) {
        this.book = book;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }


    public int numberOfWeeks(){
        Calendar a = new GregorianCalendar();
        Calendar b = new GregorianCalendar();
        a.setTime(this.date);
        b.setTime(new Date());
        return b.get(Calendar.WEEK_OF_YEAR) - a.get(Calendar.WEEK_OF_YEAR);
    }

    public Book getBook() {
        return book;
    }

}
