import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

class HelloUc3mJunit5 {

    static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;

    @BeforeAll
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }

    @Test
    void test(){
        //Exercise
        String url ="https://www.uc3m.es/Inicio";
        driver.get(url);
        String title = driver.getTitle();
        log.debug("The title of {} is {}", url,title);

        //Verify
        assertThat(title).isEqualTo("Inicio | UC3M");
    }
}
