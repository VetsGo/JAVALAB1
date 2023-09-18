package org.example;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
        library.addBook(new Book("The Daughter's Tale", "Armando Lucas Correa", "978-0-618-26303-2", 2019));
        library.addBook(new Book("Himself", "Jess Kidd", "123-1234-12-5", 2016));
    }

    @Test
    public void addBook() {
        Book book = new Book("Gorgeous Lies", "Martha McPhee", "123-4567-89-0", 2002);
        library.addBook(book);
        assertEquals(3, library.getBooks().size());
    }

    @Test
    public void findBookByTitle() {
        Book foundBook = library.findBookByTitle("The Daughter's Tale");
        assertNotNull(foundBook);
        assertEquals("The Daughter's Tale", foundBook.getTitle());
        Book foundBook2 = library.findBookByTitle("All the Missing Girls");
        assertNull(foundBook2);
    }

    @Test
    public void removeBookByISBN() {
        boolean removed = library.removeBookByISBN("978-0-618-26303-2");
        assertTrue(removed);
        assertNull(library.findBookByTitle("The Daughter's Tale"));
        boolean removed2 = library.removeBookByISBN("965-12-6182-203-0");
        assertFalse(removed2);
    }
}