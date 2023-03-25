package class1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNGexample {
    public  static WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();driver= new ChromeDriver();
       driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/loginaxtechs.net/humanresources/symfony/web/index.php/auth/login");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();

    }
    @Test(groups = "regression") //verify login functionality
  public void loginFunctionality(){
        WebElement userName=driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password=driver.findElement(By.xpath("//input[@name='txtPassword']"));
        password.sendKeys("Hum@nhrm123");

        WebElement login=driver.findElement(By.xpath("//*[@id='btnLogin']"));
        login.click();

    }  @Test
    public void passwordBoxVerification(){
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        System.out.println(passwordBox.isDisplayed());
    //verify the password textbox is displayed on the login page
}
}