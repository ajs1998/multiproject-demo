import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Library2Test {

    @Test
    void test1() {
        System.out.println("library2");
        Assertions.assertNotNull(Library2Enum.ONE);
    }

}
