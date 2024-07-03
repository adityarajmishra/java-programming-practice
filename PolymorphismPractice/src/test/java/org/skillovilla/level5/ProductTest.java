package org.skillovilla.level5;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testElectronicProduct() throws Exception {
        // Test ElectronicProduct price and details
        Class<?> electronicProductClass = Class.forName("org.skillovilla.level5.ElectronicProduct");
        Object electronicProduct = electronicProductClass.getDeclaredConstructor(String.class, String.class, double.class, int.class)
                                                         .newInstance("E001", "Laptop", 1200.0, 24);
        Method getPriceMethod = electronicProductClass.getMethod("getPrice");
        Method getDetailsMethod = electronicProductClass.getMethod("getDetails");

        double price = (double) getPriceMethod.invoke(electronicProduct);
        String details = (String) getDetailsMethod.invoke(electronicProduct);

        assertEquals(1200.0, price);
        assertEquals("Product ID: E001, Product Name: Laptop, Price: 1200.0, Warranty Period: 24 months", details);
    }

    @Test
    public void testClothingProduct() throws Exception {
        // Test ClothingProduct price and details
        Class<?> clothingProductClass = Class.forName("org.skillovilla.level5.ClothingProduct");
        Object clothingProduct = clothingProductClass.getDeclaredConstructor(String.class, String.class, double.class, String.class)
                                                     .newInstance("C001", "T-Shirt", 20.0, "L");
        Method getPriceMethod = clothingProductClass.getMethod("getPrice");
        Method getDetailsMethod = clothingProductClass.getMethod("getDetails");

        double price = (double) getPriceMethod.invoke(clothingProduct);
        String details = (String) getDetailsMethod.invoke(clothingProduct);

        assertEquals(20.0, price);
        assertEquals("Product ID: C001, Product Name: T-Shirt, Price: 20.0, Size: L", details);
    }
}
