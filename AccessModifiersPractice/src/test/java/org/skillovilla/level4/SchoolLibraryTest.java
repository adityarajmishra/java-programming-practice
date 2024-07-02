package org.skillovilla.level4;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

//public class SchoolLibraryTest {
//
//    @Test
//    public void testManageBooks() throws Exception {
//        // Access the SchoolLibrary class and its manageBooks method
//        Class<?> schoolLibraryClass = Class.forName("org.skillovilla.level4.SchoolLibrary");
//        Object schoolLibrary = schoolLibraryClass.getDeclaredConstructor().newInstance();
//        Method manageBooksMethod = schoolLibraryClass.getMethod("manageBooks");
//        manageBooksMethod.invoke(schoolLibrary);
//
//        // Access the getBooks method
//        Method getBooksMethod = schoolLibraryClass.getMethod("getBooks");
//        int books = (int) getBooksMethod.invoke(schoolLibrary);
//        assertEquals(40, books);
//    }
//
//    @Test
//    public void testAddBook() throws Exception {
//        // Access the SchoolLibrary class and its addBook method
//        Class<?> libraryClass = Class.forName("org.skillovilla.level4.Library");
//        Object library = libraryClass.getDeclaredConstructor().newInstance();
//        Method addBookMethod = libraryClass.getDeclaredMethod("addBook", int.class);
//        addBookMethod.setAccessible(true);
//        addBookMethod.invoke(library, 10);
//
//        // Access the getBooks method
//        Method getBooksMethod = libraryClass.getMethod("getBooks");
//        int books = (int) getBooksMethod.invoke(library);
//        assertEquals(10, books);
//    }
//
//    @Test
//    public void testRemoveBook() throws Exception {
//        // Access the SchoolLibrary class and its addBook and removeBook methods
//        Class<?> libraryClass = Class.forName("org.skillovilla.level4.Library");
//        Object library = libraryClass.getDeclaredConstructor().newInstance();
//        Method addBookMethod = libraryClass.getDeclaredMethod("addBook", int.class);
//        Method removeBookMethod = libraryClass.getDeclaredMethod("removeBook", int.class);
//        addBookMethod.setAccessible(true);
//        removeBookMethod.setAccessible(true);
//
//        // Add books first
//        addBookMethod.invoke(library, 10);
//        // Then remove books
//        removeBookMethod.invoke(library, 5);
//
//        // Access the getBooks method
//        Method getBooksMethod = libraryClass.getMethod("getBooks");
//        int books = (int) getBooksMethod.invoke(library);
//        assertEquals(5, books);
//    }
//}
public class SchoolLibraryTest {

    @Test
    public void testManageBooks() throws Exception {
        // Access the SchoolLibrary class and its manageBooks method
        Class<?> schoolLibraryClass = Class.forName("org.skillovilla.level4.SchoolLibrary");
        Object schoolLibrary = schoolLibraryClass.getDeclaredConstructor().newInstance();
        Method manageBooksMethod = schoolLibraryClass.getMethod("manageBooks");
        manageBooksMethod.invoke(schoolLibrary);

        // Access the getBooks method
        Method getBooksMethod = schoolLibraryClass.getMethod("getBooks");
        int books = (int) getBooksMethod.invoke(schoolLibrary);
        assertEquals(30, books); // Expecting 30 because 40 added and 10 removed
    }

    @Test
    public void testAddBook() throws Exception {
        // Access the Library class and its addBook method
        Class<?> libraryClass = Class.forName("org.skillovilla.level4.Library");
        Object library = libraryClass.getDeclaredConstructor().newInstance();
        Method addBookMethod = libraryClass.getDeclaredMethod("addBook", int.class);
        addBookMethod.setAccessible(true);
        addBookMethod.invoke(library, 10);

        // Access the getBooks method
        Method getBooksMethod = libraryClass.getMethod("getBooks");
        int books = (int) getBooksMethod.invoke(library);
        assertEquals(10, books);
    }

    @Test
    public void testRemoveBook() throws Exception {
        // Access the Library class and its addBook and removeBook methods
        Class<?> libraryClass = Class.forName("org.skillovilla.level4.Library");
        Object library = libraryClass.getDeclaredConstructor().newInstance();
        Method addBookMethod = libraryClass.getDeclaredMethod("addBook", int.class);
        Method removeBookMethod = libraryClass.getDeclaredMethod("removeBook", int.class);
        addBookMethod.setAccessible(true);
        removeBookMethod.setAccessible(true);

        // Add books first
        addBookMethod.invoke(library, 10);
        // Then remove books
        removeBookMethod.invoke(library, 5);

        // Access the getBooks method
        Method getBooksMethod = libraryClass.getMethod("getBooks");
        int books = (int) getBooksMethod.invoke(library);
        assertEquals(5, books);
    }
}
