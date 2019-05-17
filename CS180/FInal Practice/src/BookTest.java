import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * JUnit test cases for Exam 1, Question 4: Book
 */
public class BookTest {

    @Test(timeout = 100)

    public void testConstructorGetAuthor() {
        String message = "";
        Book b = new Book("title", "author", 10, 500.2);
        String expected = "title";
        String actual = b.getTitle();
        assertEquals(message, expected, actual);
    }


    @Test(timeout = 100)

    public void testConstructorGetTitle() {
        String message = "";
        Book b = new Book("title", "author", 10, 500.2);
        String expected = "author";
        String actual = b.getAuthor();
        assertEquals(message, expected, actual);
    }


    @Test(timeout = 100)

    public void testConstructorGetPages() {
        String message = "";
        Book b = new Book("title", "author", 10, 500.2);
        int expected = 10;
        int actual = b.getPages();
        assertEquals(message, expected, actual);
    }


    @Test(timeout = 100)

    public void testConstructorGetValue() {
        String message = "";
        Book b = new Book("title", "author", 10, 500.2);
        double expected = 500.2;
        double actual = b.getValue();
        assertEquals(message, expected, actual, 0.000001);
    }




}
