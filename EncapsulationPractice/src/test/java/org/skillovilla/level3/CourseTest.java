package org.skillovilla.level3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    @Test
    public void testCourseGettersAndSetters() throws Exception {
        Class<?> courseClass = Class.forName("org.skillovilla.level3.Course");
        Object course = courseClass.getDeclaredConstructor(String.class, String.class, String.class, int.class)
                .newInstance("CS101", "Intro to Computer Science", "Dr. Smith", 4);

        // Test getters
        Method getCourseCodeMethod = courseClass.getMethod("getCourseCode");
        Method getCourseNameMethod = courseClass.getMethod("getCourseName");
        Method getInstructorMethod = courseClass.getMethod("getInstructor");
        Method getCreditsMethod = courseClass.getMethod("getCredits");

        assertEquals("CS101", getCourseCodeMethod.invoke(course));
        assertEquals("Intro to Computer Science", getCourseNameMethod.invoke(course));
        assertEquals("Dr. Smith", getInstructorMethod.invoke(course));
        assertEquals(4, getCreditsMethod.invoke(course));

        // Test setters
        Method setCourseCodeMethod = courseClass.getMethod("setCourseCode", String.class);
        Method setCourseNameMethod = courseClass.getMethod("setCourseName", String.class);
        Method setInstructorMethod = courseClass.getMethod("setInstructor", String.class);
        Method setCreditsMethod = courseClass.getMethod("setCredits", int.class);

        setCourseCodeMethod.invoke(course, "CS102");
        setCourseNameMethod.invoke(course, "Data Structures");
        setInstructorMethod.invoke(course, "Dr. Johnson");
        setCreditsMethod.invoke(course, 3);

        assertEquals("CS102", getCourseCodeMethod.invoke(course));
        assertEquals("Data Structures", getCourseNameMethod.invoke(course));
        assertEquals("Dr. Johnson", getInstructorMethod.invoke(course));
        assertEquals(3, getCreditsMethod.invoke(course));
    }

    @Test
    public void testUpdateInstructor() throws Exception {
        Class<?> courseClass = Class.forName("org.skillovilla.level3.Course");
        Object course = courseClass.getDeclaredConstructor(String.class, String.class, String.class, int.class)
                .newInstance("CS101", "Intro to Computer Science", "Dr. Smith", 4);

        Method updateInstructorMethod = courseClass.getMethod("updateInstructor", String.class);
        Method getInstructorMethod = courseClass.getMethod("getInstructor");

        updateInstructorMethod.invoke(course, "Dr. Johnson");
        assertEquals("Dr. Johnson", getInstructorMethod.invoke(course));
    }

    @Test
    public void testGetCourseDetails() throws Exception {
        Class<?> courseClass = Class.forName("org.skillovilla.level3.Course");
        Object course = courseClass.getDeclaredConstructor(String.class, String.class, String.class, int.class)
                .newInstance("CS101", "Intro to Computer Science", "Dr. Smith", 4);

        Method getCourseDetailsMethod = courseClass.getMethod("getCourseDetails");
        String details = (String) getCourseDetailsMethod.invoke(course);
        assertEquals("Course Code: CS101, Course Name: Intro to Computer Science, Instructor: Dr. Smith, Credits: 4", details);
    }
}
