package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class MenuSection {

    public WebElement logoutButton;

    public MenuSection(){
        logoutButton = Session.getSession().getBrowser().findElement(By.xpath("//input[@id='email']"));
    }


}