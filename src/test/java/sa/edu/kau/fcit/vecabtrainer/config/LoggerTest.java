package sa.edu.kau.fcit.vecabtrainer.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest {

    @Test
    public void testSingleton() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        assertSame(logger1, logger2, "Logger checks if both instances are the same object");
        assertNotNull(logger1);
    }
}
