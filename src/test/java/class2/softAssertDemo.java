package class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class softAssertDemo {
    public static WebDriver driver;
    @BeforeMethod
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();

}
@Test
public void testCase(){
    WebElement loginButton = driver.findElement(By.xpath("//input[@name='Submit']"));
    loginButton.click();
WebElement error = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[5]/span"));
String errorMessage = error.getText();
String expectedError = "Username cannot be empty";
    SoftAssert soft = new SoftAssert();
    soft.assertEquals(errorMessage, expectedError);

boolean displayLogin = loginButton.isDisplayed();
soft.assertTrue(displayLogin);
// This allows you to collect all the failures in one go and continue the test execution until the end
soft.assertAll();

}
}