package Survey;

import Base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Random;

public class SurveyTests extends BaseTest {

    Random rand = new Random();
    int random = rand.nextInt(3);

    @Test
    public void CompleteSurvey(){
        WebDriverWait w = new WebDriverWait(driver,7);
        w.until(ExpectedConditions.visibilityOfElementLocated (By.className("matrixBody")));
        WebElement BodyHtml = driver.findElement(By.className("matrixBody"));
        List<WebElement> RadioBtnhtml = BodyHtml.findElements(By.className("qRadioDisplay"));
        RadioBtnhtml.get(random).click();

        driver.findElement(By.id("nextPage")).click();

        JavascriptExecutor j = (JavascriptExecutor)driver;
        w.until(ExpectedConditions.visibilityOfElementLocated (By.id("5SXMZfanSeTbGxkD2")));
        driver.findElement(By.id("5SXMZfanSeTbGxkD2")).click();
        j.executeScript ("document.getElementById('5SXMZfanSeTbGxkD2').value='7'");
        driver.findElement(By.id("nextPage")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated (By.className("matrixBody")));
        WebElement Radiohtml = driver.findElement(By.className("matrixBody"));
        w.until(ExpectedConditions.visibilityOfElementLocated (By.className("qRadio")));
        List<WebElement> Question3Radio = Radiohtml.findElements(By.className("qRadio"));
        Question3Radio.get(random).click();
        driver.findElement(By.id("nextPage")).click();
        driver.navigate().to("https://app.quantilope.com/share/PJoeMXtgn96cY65bq?type=dashboard");
    }
}
