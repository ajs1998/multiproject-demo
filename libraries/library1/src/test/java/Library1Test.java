import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class Library1Test {

    @Test
    void slowTest() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(5).toMillis());
    }

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

    @Test
    void testApi1() {
        Api1 api = () -> 1;
        Assertions.assertEquals(1, api.return1());
    }

}
