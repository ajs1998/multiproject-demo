import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Service1Test {

    @Test
    void test1() {
        System.out.println("Service1");
        Assertions.assertTrue(true);
    }

    @Test
    void testLibrary1() {
        // Dependency is implementation(":library1")
        Assertions.assertNotNull(Library1Enum.ONE);
    }

    @Test
    void testLibrary2() {
        // In library1: dependency is implementation(":library2")
        // library2 is not a transitive dependency
//        Assertions.assertNull(Library2Enum.ONE);
    }

    private final Api1 api = () -> 1;

    @Test
    void testApi1() {
        // In library1: dependency is api(":api1")
        // api1 is a transitive dependency
        Assertions.assertEquals(1, api.return1());
    }

}
