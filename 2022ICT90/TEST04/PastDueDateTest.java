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

public class PastDueDateTest {

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
    public void TC04_AddTaskWithPastDeadline() {

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

        // Step 3: Enter task details
        driver.findElement(By.id("title"))
                .sendKeys("Past Deadline Test Task");

        // Enter past date: 01/01/2020 10:00 AM
        WebElement deadline = driver.findElement(By.id("deadline"));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = '2020-01-01T10:00';" +
                        "arguments[0].dispatchEvent(new Event('input', {bubbles:true}));" +
                        "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                deadline
        );

        new Select(driver.findElement(By.id("priority")))
                .selectByVisibleText("High");

        new Select(driver.findElement(By.id("status")))
                .selectByVisibleText("Pending");

        System.out.println("Entered deadline: " + deadline.getAttribute("value"));

        // Step 4: Check form validation
        Boolean formValid = (Boolean) ((JavascriptExecutor) driver)
                .executeScript(
                        "return document.getElementById('task-form').checkValidity();"
                );

        System.out.println("Form valid: " + formValid);

        // If browser validation rejects the past date, test passes
        if (!formValid) {
            System.out.println("TC04 PASSED: Past deadline rejected by form validation.");
            return;
        }

        // Step 5: Monitor the task API response
        ((JavascriptExecutor) driver).executeScript(
                "window.taskRequestResult = 'NOT_SENT';" +
                        "const originalFetch = window.fetch;" +
                        "window.fetch = async function(...args) {" +
                        " const response = await originalFetch.apply(this, args);" +
                        " if (String(args[0]).includes('/api/tasks')) {" +
                        "   window.taskRequestResult = 'HTTP ' + response.status;" +
                        " }" +
                        " return response;" +
                        "};"
        );

        // Step 6: Click Add Task
        driver.findElement(By.id("submit-btn")).click();

        // Step 7: Wait for API response
        wait.until(d -> {
            String result = (String) ((JavascriptExecutor) d)
                    .executeScript("return window.taskRequestResult;");

            return result != null && !result.equals("NOT_SENT");
        });

        String apiResult = (String) ((JavascriptExecutor) driver)
                .executeScript("return window.taskRequestResult;");

        System.out.println("API result: " + apiResult);

        // Step 8: Verify expected result
        boolean taskRejected = !apiResult.equals("HTTP 201");

        Assert.assertTrue(
                taskRejected,
                "TC04 FAILED: Taskium accepted a task with a past deadline!"
        );

        System.out.println("TC04 PASSED: Taskium rejected the past deadline.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}