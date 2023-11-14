package question5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-5 - ProjectName : com-utimateqa
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */
public class Test {
    static String baseUrl = "https://courses.ultimateqa.com/";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) {

        // Setup browser
        if (browser.trim().equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser");
        }

        //Open the URl into browser
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //current url
        System.out.println("The current url : " + driver.getCurrentUrl());

        //Page source
        System.out.println(driver.getPageSource());

        //Click on ‘Sign In’ link
        driver.findElement(By.cssSelector("a[href^='/users/sign_in']")).click();

        //Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //Find Email field Element ant Type the Email
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Ram99@gmail.com");

        //Find Password field Element ant Type the Email
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Ram123");

        // Click on login button
        driver.findElement(By.cssSelector("button[type^='submit']")).click();

        //Navigate to base URL
        driver.navigate().to(baseUrl);

        //Navigate forward to homepage
        driver.navigate().forward();

        //Navigate back to base URL
        driver.navigate().back();

        //Refresh the page
        driver.navigate().refresh();

        //Close the browser
        driver.quit();
    }
}
