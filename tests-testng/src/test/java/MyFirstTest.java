import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTest {

    private Logger logger = LogManager.getLogger(MyFirstTest.class);
    protected static WebDriver driver;

    @Test
    public void LogExample() {
        logger.info("Тест старт");
    }

    @BeforeMethod
    public void StartUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @AfterMethod
    public void End() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void WebDriverTest() {
        driver.get("https://otus.ru");
        logger.info("Сайт открыт");
    }

    @Test
    public void WebDriverTitle() {
        driver.getTitle();
        logger.info("Заголовок получен");
    }
}
