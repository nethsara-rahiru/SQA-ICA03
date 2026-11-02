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

public class UnRegisteredEmaiil {

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
    public void TC03_UnregisteredEmail() {

        driver.findElement(By.id("email"))
                .sendKeys("unknown_user_987654@example.com");

        driver.findElement(By.id("password"))
                .sendKeys("TestPassword123!");

        driver.findElement(By.cssSelector("button[type='submit']"))
                .click();

        WebElement errorToast = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".toast-error")
                )
        );

        Assert.assertTrue(
                errorToast.isDisplayed(),
                "TC03 FAILED: Error message was not displayed!"
        );

        Boolean tokenExists = (Boolean)
                ((JavascriptExecutor) driver).executeScript(
                        "return !!JSON.parse(localStorage.getItem('user') || 'null')?.token;"
                );

        Assert.assertFalse(
                tokenExists,
                "TC03 FAILED: Token should not be stored for an unregistered email!"
        );

        System.out.println("TC03 PASSED: Unregistered email was rejected!");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

}
