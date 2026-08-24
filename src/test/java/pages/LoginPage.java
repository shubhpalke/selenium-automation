package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private By username = By.xpath("//input[@name='email']");
    private By password = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//input[@type='submit']");

    public void login(String user, String pass) {
        elementActions.type(username, user);
        elementActions.type(password, pass);
        elementActions.click(loginBtn);
    }
}
