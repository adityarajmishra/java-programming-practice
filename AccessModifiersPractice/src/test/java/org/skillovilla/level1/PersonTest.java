package org.skillovilla.level1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void testPersonGettersAndSetters() throws Exception {
        Class<?> personClass = Class.forName("org.skillovilla.level1.Person");
        Object person = personClass.getDeclaredConstructor().newInstance();

        // Test public access modifier
        Method setNameMethod = personClass.getMethod("setName", String.class);
        Method getNameMethod = personClass.getMethod("getName");
        setNameMethod.invoke(person, "Alice");
        String name = (String) getNameMethod.invoke(person);
        assertEquals("Alice", name);

        // Test protected access modifier
        Method setAgeMethod = personClass.getMethod("setAge", int.class);
        Method getAgeMethod = personClass.getMethod("getAge");
        setAgeMethod.invoke(person, 25);
        int age = (int) getAgeMethod.invoke(person);
        assertEquals(25, age);

        // Test default access modifier
        Method setAddressMethod = personClass.getMethod("setAddress", String.class);
        Method getAddressMethod = personClass.getMethod("getAddress");
        setAddressMethod.invoke(person, "123 Main St");
        String address = (String) getAddressMethod.invoke(person);
        assertEquals("123 Main St", address);

        // Test private access modifier
        Method setPhoneNumberMethod = personClass.getDeclaredMethod("setPhoneNumber", String.class);
        Method getPhoneNumberMethod = personClass.getDeclaredMethod("getPhoneNumber");
        setPhoneNumberMethod.setAccessible(true);
        getPhoneNumberMethod.setAccessible(true);
        setPhoneNumberMethod.invoke(person, "123-456-7890");
        String phoneNumber = (String) getPhoneNumberMethod.invoke(person);
        assertEquals("123-456-7890", phoneNumber);
    }
}
