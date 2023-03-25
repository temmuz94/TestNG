package class1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionBasic1 {
    public static WebDriver driver;

    @BeforeMethod
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/loginaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void InvalidCredentials() {
        try {
            WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
            userName.sendKeys("Admin");

            WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
            password.sendKeys("imamhatiplerkapatilsin");

            WebElement login = driver.findElement(By.xpath("//*[@id='btnLogin']"));
            login.click();

            // password textbox is displayed
            // finding the password again as it is discarded when we clicked on login button because the DOM refreshed
            password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
            boolean passwordDisplayedB = password.isDisplayed();
            // verify the textBox is displayed
            Assert.assertTrue(passwordDisplayedB);
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }
}
