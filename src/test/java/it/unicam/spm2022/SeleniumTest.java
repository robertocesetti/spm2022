package it.unicam.spm2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class SeleniumTest {

    static WebDriver driver;

    @BeforeAll
    static void setup() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
        String projectPath = System.getProperty("user.dir");

        If using Firefox driver then remove quit in closeAll() method
        System.setProperty("webdriver.gecko.drive", projectPath + "/drivers/geckodriver.exe");
        driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.drive", projectPath + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();*/
    }

    @Test
    void checkProsSite() throws InterruptedException {
        driver.get("http://pros.unicam.it/");

        Thread.sleep(3000);

        String at = driver.getTitle();
        String et = "PROS - PROcesses & Services lab | Computer Science division @Unicam";

        Thread.sleep(4000);

        Assertions.assertEquals(et, at);

    }

    @Test
    @Disabled
    void checkProsSiteSearch() throws InterruptedException {

        driver.get("http://pros.unicam.it/");
        Thread.sleep(2000);

        //Find Element by className
        driver.findElement(By.className("toggle-search")).click();
        Thread.sleep(2000);

        WebElement textbox = driver.findElement(By.className("search"));

        textbox.click();
        Thread.sleep(2000);

        textbox.sendKeys("bprove");
        textbox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        List<WebElement> links = driver.findElements(By.className("type-portfolio-title"));

        for (WebElement ele : links) {
            String element = ele.findElement(By.tagName("a")).getAttribute("href");
                assertTrue(element.contains("bprove"));
        }
    }

    @AfterAll
    static void closeAll() throws InterruptedException {
        driver.close();
        driver.quit();
    }

}