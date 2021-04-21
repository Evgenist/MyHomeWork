import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class MyFirstTest {

    private Logger logger = LogManager.getLogger(MyFirstTest.class);
    protected static WebDriver driver;

    @Test
    public void logExample() {
        logger.info("Тест старт");
    }

    @BeforeMethod
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @AfterMethod
    public void end() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void webDriverTest() {
        driver.get("https://otus.ru");
        logger.info("Сайт открыт");
        logger.info("Заголовок получен");
        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle);
    }
}
