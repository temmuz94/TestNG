package class1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionBasic {
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
    public void InvalidCredentials(){
        WebElement userName=driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");

        WebElement password=driver.findElement(By.xpath("//input[@name='txtPassword']"));
        password.sendKeys("imamhatiplerkapatilsin");

        WebElement login=driver.findElement(By.xpath("//*[@id='btnLogin']"));
        login.click();

        //verify the error message
        WebElement error = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorMessage=error.getText();
        //check if a message is correct
        String exceptedError="Invalid credential";
        //assert the value
        Assert.assertEquals(exceptedError, errorMessage);//failed cuz exceptedError should be "Invalid credentials"line 46

        //Read the status bar


    }
}
