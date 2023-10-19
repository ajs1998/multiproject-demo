import org.junit.jupiter.api.Test;

import java.time.Duration;

public class Api1Test {

    @Test
    void longTest() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(5).toMillis());
    }

}
