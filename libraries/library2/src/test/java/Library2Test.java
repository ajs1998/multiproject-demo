import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class Library2Test {

    @Test
    void longTest() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(5).toMillis());
    }

    @Test
    void test1() {
        System.out.println("library2");
        Assertions.assertNotNull(Library2Enum.ONE);
    }

}
