package WithPageObjectModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LoggerTest {
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Test
    public void loggerTest() {
        log.trace("This is a trace log");
        log.debug("This is a debug log");
        log.info("This is a info log");
        log.warn("This is a warn log");
        log.error("This is a error log");
    }
}
