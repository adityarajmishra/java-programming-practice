package section3.level3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Level3CombinedTest {

    @Test
    public void testEmployee3SalaryField() {
        try {
            Class<?> employee3Class = Class.forName("section3.level3.Employee3");

            Field salaryField = employee3Class.getDeclaredField("salary");
            assertEquals(int.class, salaryField.getType(), "salary should be of type int.");
            assertEquals("protected", Modifier.toString(salaryField.getModifiers()), "salary should be protected.");
        } catch (ClassNotFoundException e) {
            fail("Employee3 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testAnalyst3AnalystTeamSecretAccessField() {
        try {
            Class<?> analyst3Class = Class.forName("section3.level3.employees.Analyst3");

            Field secretAccessField = analyst3Class.getDeclaredField("analystTeamSecretAccess");
            assertEquals(int.class, secretAccessField.getType(), "analystTeamSecretAccess should be of type int.");
            assertEquals("private", Modifier.toString(secretAccessField.getModifiers()), "analystTeamSecretAccess should be private.");
        } catch (ClassNotFoundException e) {
            fail("Analyst3 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testDeveloper3DevelopersCodePasswordField() {
        try {
            Class<?> developer3Class = Class.forName("section3.level3.employees.Developer3");

            Field codePasswordField = developer3Class.getDeclaredField("developersCodePassword");
            assertEquals(String.class, codePasswordField.getType(), "developersCodePassword should be of type String.");
            assertEquals("private", Modifier.toString(codePasswordField.getModifiers()), "developersCodePassword should be private.");
        } catch (ClassNotFoundException e) {
            fail("Developer3 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testRecruiter3RecruitingSecretsField() {
        try {
            Class<?> recruiter3Class = Class.forName("section3.level3.employees.Recruiter3");

            Field secretsField = recruiter3Class.getDeclaredField("recruitingSecrets");
            assertEquals(String.class, secretsField.getType(), "recruitingSecrets should be of type String.");
            assertEquals("private", Modifier.toString(secretsField.getModifiers()), "recruitingSecrets should be private.");
        } catch (ClassNotFoundException e) {
            fail("Recruiter3 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }
}
