package evaluations.level11.gameobjects;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpaceShipTest {

    @Test
    public void testConstructorAndGetters() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level11.gameobjects.SpaceShip");
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class, int.class, int.class);
        Object instance = constructor.newInstance("Apollo", 50, 0, 0);

        Method getPositionXMethod = clazz.getMethod("getPositionX");
        Method getPositionYMethod = clazz.getMethod("getPositionY");

        int positionX = (int) getPositionXMethod.invoke(instance);
        int positionY = (int) getPositionYMethod.invoke(instance);

        assertEquals(0, positionX);
        assertEquals(0, positionY);
    }

    @Test
    public void testMoveMethods() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level11.gameobjects.SpaceShip");
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class, int.class, int.class);
        Object instance = constructor.newInstance("Apollo", 50, 0, 0);

        Method moveUpMethod = clazz.getMethod("moveUp");
        Method moveDownMethod = clazz.getMethod("moveDown");
        Method moveLeftMethod = clazz.getMethod("moveLeft");
        Method moveRightMethod = clazz.getMethod("moveRight");

        moveUpMethod.invoke(instance);
        assertEquals(1, clazz.getMethod("getPositionY").invoke(instance));

        moveDownMethod.invoke(instance);
        assertEquals(0, clazz.getMethod("getPositionY").invoke(instance));

        moveLeftMethod.invoke(instance);
        assertEquals(-1, clazz.getMethod("getPositionX").invoke(instance));

        moveRightMethod.invoke(instance);
        assertEquals(0, clazz.getMethod("getPositionX").invoke(instance));
    }

    @Test
    public void testDisplayStatus() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level11.gameobjects.SpaceShip");
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class, int.class, int.class);
        Object instance = constructor.newInstance("Apollo", 50, 0, 0);

        Method displayStatusMethod = clazz.getMethod("displayStatus");
        displayStatusMethod.invoke(instance);

        Method refuelMethod = clazz.getMethod("refuel", int.class);
        refuelMethod.invoke(instance, 20);
        displayStatusMethod.invoke(instance);
    }

    @Test
    public void testAbstractClassAndInterfaceImplementation() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level11.gameobjects.SpaceShip");

        // Check if SpaceShip is a subclass of GameObject
        Class<?> superclass = clazz.getSuperclass();
        assertEquals("evaluations.level11.GameObject", superclass.getName());

        // Check if SpaceShip implements Movable interface
        Class<?>[] interfaces = clazz.getInterfaces();
        boolean implementsMovable = false;
        for (Class<?> iface : interfaces) {
            if (iface.getName().equals("evaluations.level11.Movable")) {
                implementsMovable = true;
                break;
            }
        }
        assertTrue(implementsMovable);
    }
}
