import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void Test1() {
        String name = "TestName";
        String surname = "TestSurname";
        String email = "testuser@test.com";
        String password = "Qwerty12345";

        driver.get("https://thisistest.com/signup");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("surname")).sendKeys(surname);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("register")).click();
        assert driver.findElement(By.id("actionSuccess")).isDisplayed();

        driver.get("https://thisistest.com/login");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();

        assert driver.findElement(By.id("user")).getText() == email;

    }

}
