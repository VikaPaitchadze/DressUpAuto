package ge.automation.hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(Hooks.class); // ლოგერის ინიციალიზაცია

    public static void setup() {
        logger.info("Initializing WebDriver"); // ლოგირება პროცესის დაწყებისას
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            logger.info("WebDriver initialized successfully"); // წარმატებული ინიციალიზაციის ლოგი
        } catch (Exception e) {
            logger.error("Error during WebDriver initialization: ", e); // შეცდომის ლოგი
            throw new RuntimeException("Failed to initialize WebDriver.", e);
        }
    }

    public static void tearDown() {
        logger.info("Closing WebDriver"); // ლოგი დახურვის პროცესის დაწყებისას
        if (driver != null) {
            try {
                driver.quit();
                driver = null;
                logger.info("WebDriver closed successfully"); // წარმატებული დახურვის ლოგი
            } catch (Exception e) {
                logger.error("Error during WebDriver closing: ", e); // შეცდომის ლოგი
            }
        } else {
            logger.warn("WebDriver is already null. Nothing to close"); // გაფრთხილების ლოგი
        }
    }
}