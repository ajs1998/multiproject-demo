import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class Service1Test {

    @Test
    void longTest() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(5).toMillis());
    }

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

    @Test
    void testApi1() {
        // In library1: dependency is api(":api1")
        // api1 is a transitive dependency
        Api1 api = () -> 1;
        Assertions.assertEquals(1, api.return1());
    }

}
