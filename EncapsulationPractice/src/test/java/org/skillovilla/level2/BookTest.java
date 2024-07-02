package org.skillovilla.level2;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void testBookGettersAndSetters() throws Exception {
        Class<?> bookClass = Class.forName("org.skillovilla.level2.Book");
        Object book = bookClass.getDeclaredConstructor(String.class, String.class, String.class, double.class)
                .newInstance("1234567890", "Java Programming", "John Doe", 29.99);

        // Test getters
        Method getIsbnMethod = bookClass.getMethod("getIsbn");
        Method getTitleMethod = bookClass.getMethod("getTitle");
        Method getAuthorMethod = bookClass.getMethod("getAuthor");
        Method getPriceMethod = bookClass.getMethod("getPrice");

        assertEquals("1234567890", getIsbnMethod.invoke(book));
        assertEquals("Java Programming", getTitleMethod.invoke(book));
        assertEquals("John Doe", getAuthorMethod.invoke(book));
        assertEquals(29.99, getPriceMethod.invoke(book));

        // Test setters
        Method setIsbnMethod = bookClass.getMethod("setIsbn", String.class);
        Method setTitleMethod = bookClass.getMethod("setTitle", String.class);
        Method setAuthorMethod = bookClass.getMethod("setAuthor", String.class);
        Method setPriceMethod = bookClass.getMethod("setPrice", double.class);

        setIsbnMethod.invoke(book, "0987654321");
        setTitleMethod.invoke(book, "Advanced Java");
        setAuthorMethod.invoke(book, "Jane Smith");
        setPriceMethod.invoke(book, 39.99);

        assertEquals("0987654321", getIsbnMethod.invoke(book));
        assertEquals("Advanced Java", getTitleMethod.invoke(book));
        assertEquals("Jane Smith", getAuthorMethod.invoke(book));
        assertEquals(39.99, getPriceMethod.invoke(book));
    }

    @Test
    public void testApplyDiscount() throws Exception {
        Class<?> bookClass = Class.forName("org.skillovilla.level2.Book");
        Object book = bookClass.getDeclaredConstructor(String.class, String.class, String.class, double.class)
                .newInstance("1234567890", "Java Programming", "John Doe", 29.99);

        Method applyDiscountMethod = bookClass.getMethod("applyDiscount", double.class);
        Method getPriceMethod = bookClass.getMethod("getPrice");

        applyDiscountMethod.invoke(book, 10.0);
        assertEquals(26.99, (double) getPriceMethod.invoke(book), 0.01);
    }

    @Test
    public void testGetBookDetails() throws Exception {
        Class<?> bookClass = Class.forName("org.skillovilla.level2.Book");
        Object book = bookClass.getDeclaredConstructor(String.class, String.class, String.class, double.class)
                .newInstance("1234567890", "Java Programming", "John Doe", 29.99);

        Method getBookDetailsMethod = bookClass.getMethod("getBookDetails");
        String details = (String) getBookDetailsMethod.invoke(book);
        assertEquals("ISBN: 1234567890, Title: Java Programming, Author: John Doe, Price: 29.99", details);
    }
}
