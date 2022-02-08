
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;

public class HelloWorldJUnit4{

    static final Logger log = getLogger(lookup().lookupClass());
    WebDriver driver;

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }
    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test(){

        String url ="https://google.com";
        driver.get(url);
        String title = driver.getTitle();
        log.debug("The title of {} is {}", url,title);
        //Verify
        assertThat(title).isEqualTo("Google");
    }


}
