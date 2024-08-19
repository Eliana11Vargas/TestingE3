package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class LoginSection {

    public WebElement emailTxtBox;
    public WebElement pwdTxtBox;
    public WebElement loginButton;

    public  LoginSection(){
        //emailTxtBox = Session.getSession().getBrowser().findElement(By.xpath("//input[@id='email']"));
        pwdTxtBox = Session.getSession().getBrowser().findElement(By.xpath("//input[@id='password']"));
        loginButton = Session.getSession().getBrowser().findElement(By.xpath("//button[@id='loginButton']"));

    }

}