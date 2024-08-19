package testSuite;

import org.junit.jupiter.api.*;
import pages.LoginSection;
import pages.MainPage;
import pages.MenuSection;
import session.Session;

public class Login2Test {

    @BeforeEach
    public void openBrowser(){
        Session.getSession().getBrowser().get("https://demo.owasp-juice.shop/#/login");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getSession().getBrowser().quit();
    }

    @Test
    @Order(1)
    public void verifyLoginSuccessfully() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.emailTxtBox.click();

        LoginSection loginSection = new LoginSection();
        loginSection.emailTxtBox.sendKeys("zap@zap2024.com");
        loginSection.pwdTxtBox.sendKeys("12345");
        loginSection.loginButton.click();

        MenuSection menuSection = new MenuSection();
        // verification
        Assertions.assertTrue(menuSection.logoutButton.isDisplayed(),
                "ERROR> no se pudo iniciar sesion");
    }

}