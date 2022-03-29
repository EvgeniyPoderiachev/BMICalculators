import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class BMICalculatorsTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://healthunify.com/bmicalculator/");
    }

    @Test
    public void categoryShouldBeStarvation() {
        driver.findElement(By.name("wg")).sendKeys("35");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Starvation");
    }
    @Test
    public void categoryShouldBeStarvation2() {
        driver.findElement(By.name("wg")).sendKeys("38.3");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Starvation");
    }

    @Test
    public void categoryShouldBeUnderweight() {
        driver.findElement(By.name("wg")).sendKeys("38.42");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Underweight");
    }

    @Test
    public void categoryShouldBeUnderweight2() {
        driver.findElement(By.name("wg")).sendKeys("47.37");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Underweight");
    }

    @Test
    public void categoryShouldBeNormal() {
        driver.findElement(By.name("wg")).sendKeys("47.38");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Normal");
    }
    @Test
    public void categoryShouldBeNormal2() {
        driver.findElement(By.name("wg")).sendKeys("64");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Normal");
    }

    @Test
    public void categoryShouldBeOverweight() {
        driver.findElement(By.name("wg")).sendKeys("64.1");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Overweight");
    }
    @Test
    public void categoryShouldBeOverweight2() {
        driver.findElement(By.name("wg")).sendKeys("76.8");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Overweight");
    }
    @Test
    public void categoryShouldBeObese() {
        driver.findElement(By.name("wg")).sendKeys("76.9");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Obese");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
