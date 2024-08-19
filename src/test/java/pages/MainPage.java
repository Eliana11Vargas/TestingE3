package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class MainPage {
    public WebElement emailTxtBox;

    public MainPage(){
        emailTxtBox = Session.getSession().getBrowser().findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]"));
    }

}