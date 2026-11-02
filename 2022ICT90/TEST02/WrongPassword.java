import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WrongPassword{


    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:8000/login.html");
    }

    @Test
    public void TC02_InvalidPassword() {

        driver.findElement(By.id("email"))
                .sendKeys("abcd@gmail.com");

        driver.findElement(By.id("password"))
                .sendKeys("WrongPassword123!");

        driver.findElement(By.cssSelector("button[type='submit']"))
                .click();

        WebElement errorToast = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".toast-error")
                )
        );

        Assert.assertTrue(
                errorToast.isDisplayed(),
                "TC02 FAILED: Error message was not displayed!"
        );

        Boolean tokenExists = (Boolean)
                ((JavascriptExecutor) driver).executeScript(
                        "return !!JSON.parse(localStorage.getItem('user') || 'null')?.token;"
                );

        Assert.assertFalse(
                tokenExists,
                "TC02 FAILED: Token should not be stored after invalid login!"
        );

        System.out.println("TC02 PASSED: Invalid password was rejected!");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

}
