package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static java.lang.Thread.sleep;

public class BaseTest {
    protected WebDriver driver;

    public  BaseTest(){setUp();}


    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://survey.quantilope.com/SfidqfGjdrvMzwzWK/wp9pBZvxJStxgYx4T/9xednGW4bJAGd7sv2");

        WebDriverWait w = new WebDriverWait(driver,2);
        // presenceOfElementLocated condition
        w.until(ExpectedConditions.presenceOfElementLocated (By.id("startSurvey")));

        driver.manage().window().maximize();
        driver.findElement(By.id("startSurvey")).click();
    }


   /* @AfterClass
    public void tearDown()
    {
        driver.quit();
    }*/

}

