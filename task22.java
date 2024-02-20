package Task22;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class task22 {

    public static void main(String[] args) {
        // Set the path to chromedriver.exe
        

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the form page
        driver.get("https://phptravels.com/demo/");

        // Fill in the form details
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        firstNameInput.sendKeys("Michel");

        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys("Jordan");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("jodogad992@minhlun.com");

        // Generate two random numbers
        int num1 = (int) (Math.random() * 50) + 1;
        int num2 = (int) (Math.random() * 50) + 1;

        // Fill in the sum of two numbers
        WebElement sumInput = driver.findElement(By.name("sum"));
        sumInput.sendKeys(String.valueOf(num1 + num2));

        // Click on Submit button
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();

        // Wait for success message
        WebDriverWait wait = new WebDriverWait (driver, 10);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Form Submitted Successfully')]")));

        // Verify success message
        if (successMessage.isDisplayed()) {
            System.out.println("Form submitted successfully!");
        } else {
            System.out.println("Form submission failed!");
        }
        
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        // Close the browser
        driver.quit();
    }
}
