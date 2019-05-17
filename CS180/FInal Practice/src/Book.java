/**
 * Exam
 * Question 3 -- Book
 *
 * Create a class Book that implements the following methods
 *
 * public String getTitle();
 * public String getAuthor();
 * public int getPages();
 * public double getValue();
 *
 * The class Book must have the private instance variables:
 * title (String), author (String), pages (int)
 * and value (double). You must write a constructor
 * that gives each of these an initial value.
 *
 *
 */
public class Book {
    private String title;
    private String author;
    private int pages;
    private double value;


    public Book(String title, String author, int pages, double value) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.value = value;
    }

    public String getTitle() {
        return title; // delete this line and implement your own solution
    }


    public String getAuthor() {
        return author; // delete this line and implement your own solution
    }

    public int getPages() {
        return pages; // delete this line and implement your own solution
    }


    public double getValue() {
        return value; // delete this line and implement your own solution
    }

}