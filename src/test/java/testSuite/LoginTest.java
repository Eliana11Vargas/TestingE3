package testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LoginTest {

    WebDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("127.0.0.1:9292");
        proxy.setSslProxy("127.0.0.1:9292");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("ignore-certificate-errors");

        Map<String,Object> prefs=  new HashMap<>();
        prefs.put("credentials_enable_service",false);
        chromeOptions.setExperimentalOption("prefs",prefs);
        chromeOptions.setProxy(proxy);

        chrome = new ChromeDriver(chromeOptions);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chrome.manage().window().maximize();
        chrome.get("https://demo.owasp-juice.shop/#/login");
    }

    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }

    // @Test
    //@Order(1)
    public void verifyLoginSuccessfully() throws InterruptedException {
        Thread.sleep(5000);
        // set email
        chrome.findElement(By.xpath("//input[@id='email']")).sendKeys("dennys123@dennys123.com");
        // set pwd
        chrome.findElement(By.xpath("//input[@id='password']")).sendKeys("dennys123");
        // click login button
        chrome.findElement(By.xpath("//button[@id='loginButton']")).click();
        // verification
        Assertions.assertTrue(chrome.findElement(By.xpath("//button[@id='navbarAccount']")).isDisplayed(),
                "ERROR> no se pudo iniciar sesion");
    }

}