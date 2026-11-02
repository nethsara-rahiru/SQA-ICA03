import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {


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
    public void TC01_ValidLogin() {

        // Enter registered email
        driver.findElement(By.id("email"))
                .sendKeys("abcd@gmail.com");

        // Enter correct password
        driver.findElement(By.id("password"))
                .sendKeys("abc2001");

        // Click Login button
        driver.findElement(
                By.cssSelector("button[type='submit']")
        ).click();

        // Wait until authentication token is stored
        Boolean tokenExists = wait.until(d -> {

            JavascriptExecutor js = (JavascriptExecutor) d;

            return (Boolean) js.executeScript(
                    "return !!JSON.parse(localStorage.getItem('user') || 'null')?.token;"
            );
        });

        // Verify login
        Assert.assertTrue(
                tokenExists,
                "TC01 FAILED: Login unsuccessful!"
        );

        System.out.println("TC01 PASSED: Valid login successful!");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }


}
