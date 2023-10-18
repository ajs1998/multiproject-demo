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

    /*
     * The automatic loading of test framework implementation dependencies has been deprecated.
     * This is scheduled to be removed in Gradle 9.0.
     * Declare the desired test framework directly on the test suite
     * or explicitly declare the test framework implementation dependencies on the test's runtime classpath.
     * Consult the upgrading guide for further information:
     * https://docs.gradle.org/8.4/userguide/upgrading_version_8.html#test_framework_implementation_dependencies
     */

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
