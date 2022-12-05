package it.unicam.spm2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebAppTest {

    static WebDriver driver;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
        String projectPath = System.getProperty("user.dir");

        //If using Firefox driver then remove quit in closeAll() method
        System.setProperty("webdriver.gecko.drive", projectPath + "/drivers/geckodriver.exe");
        driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.drive", projectPath + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();*/
    }

    @Test
    void checkWebPageTitle() throws InterruptedException {
        driver.get("http://localhost:8080/spm2022");
        Thread.sleep(2000);

        String title = driver.getTitle();
        String titleCompare = "SPM 2022";

        //System.out.println(title);
        Thread.sleep(2000);

        Assert.assertEquals(title, titleCompare);

    }

    @AfterAll
    static void closeAll() throws InterruptedException {
        driver.close();
        driver.quit();
    }

}
