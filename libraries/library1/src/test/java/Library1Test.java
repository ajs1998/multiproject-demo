import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Library1Test {

    @Test
    void test1() {
        System.out.println("library1");
        Assertions.assertNotNull(Library1Enum.ONE);
    }

    @Test
    void test2() {
        System.out.println("Depends on library2");
        Assertions.assertNotNull(Library2Enum.ONE);
    }

    private final Api1 api = () -> 1;

    @Test
    void testApi1() {
        Assertions.assertEquals(1, api.return1());
    }

}
