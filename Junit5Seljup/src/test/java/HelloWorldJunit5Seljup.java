import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

@ExtendWith(SeleniumJupiter.class)
public class HelloWorldJunit5Seljup {

    static final Logger log = getLogger(lookup().lookupClass());

    @Test
    public void test(ChromeDriver driver){
        String url = "https://google.com";
        driver.get(url);
        String title = driver.getTitle();
        log.debug("Google");

        //Check
        assertThat(title).isEqualTo("Google");
    }
}
