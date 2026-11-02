import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MultilingualTaskTest {


    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("http://localhost:8000/login.html");
    }

    @Test
    public void TC06_AddMultilingualTask() {

        // Step 1: Login
        driver.findElement(By.id("email"))
                .sendKeys("abcdf@gmail.com");

        driver.findElement(By.id("password"))
                .sendKeys("abcdf2001");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(d -> (Boolean) ((JavascriptExecutor) d).executeScript(
                "return !!JSON.parse(localStorage.getItem('user') || 'null')?.token;"
        ));

        wait.until(ExpectedConditions.urlToBe("http://localhost:8000/"));

        System.out.println("Login successful.");

        // Step 2: Open Add New Task modal
        ((JavascriptExecutor) driver).executeScript(
                "document.getElementById('task-modal').style.display = 'flex';"
        );

        // Step 3: Enter a multilingual task title
        String taskTitle = "Team Meeting - தமிழ் - සිංහල";

        driver.findElement(By.id("title"))
                .sendKeys(taskTitle);

        // Step 4: Enter a future deadline
        WebElement deadline = driver.findElement(By.id("deadline"));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = '2030-01-01T10:00';" +
                        "arguments[0].dispatchEvent(new Event('input', {bubbles:true}));" +
                        "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                deadline
        );

        new Select(driver.findElement(By.id("priority")))
                .selectByVisibleText("High");

        new Select(driver.findElement(By.id("status")))
                .selectByVisibleText("Pending");

        System.out.println("Task title: " + taskTitle);

        // Step 5: Click Add Task
        driver.findElement(By.id("submit-btn")).click();

        // Step 6: Wait for the task to appear
        WebElement taskCard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//div[contains(@class,'task-card') and contains(.,'Team Meeting')]"
                        )
                )
        );

        String displayedText = taskCard.getText();

        System.out.println("Displayed task: " + displayedText);

        // Step 7: Verify multilingual text
        Assert.assertTrue(
                displayedText.contains("தமிழ்"),
                "TC06 FAILED: Tamil text was not displayed correctly."
        );

        Assert.assertTrue(
                displayedText.contains("සිංහල"),
                "TC06 FAILED: Sinhala text was not displayed correctly."
        );

        System.out.println(
                "TC06 PASSED: Taskium created and displayed the multilingual task correctly."
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
