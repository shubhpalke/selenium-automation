package pages;

import org.openqa.selenium.By;

public class LandingPage extends BasePage{

    private By myAccountBtn = By.xpath("//a[@title='My Account']");
    private By registerBtn = By.xpath("//a[.='Register']");
    private By loginBtn = By.xpath("//a[.='Login']");

    public RegisterPage goToRegisterPage(){

        elementActions.click(myAccountBtn);
        elementActions.click(registerBtn);
        RegisterPage registerPage = new RegisterPage();
        return registerPage;
    }

    public LoginPage goToLoginPage(){

        elementActions.click(myAccountBtn);
        elementActions.click(loginBtn);

        LoginPage loginPage = new LoginPage();
        return loginPage;
    }
}
