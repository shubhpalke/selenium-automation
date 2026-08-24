package pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage{

    private By firstNameTxt = By.xpath("//input[@name='firstname']");
    private By lastNameTxt = By.xpath("//input[@name='lastname']");
    private By emailTxt = By.xpath("//input[@name='email']");
    private By telephoneTxt = By.xpath("//input[@name='telephone']");
    private By passwordTxt = By.xpath("//input[@name='password']");
    private By confirmPasswordTxt = By.xpath("//input[@name='confirm']");
    private By checkBox = By.xpath("//input[@type='checkbox']");
    private By continueBtn = By.xpath("//input[@type='submit']");


    // Action methods for register page objects
    public void register(String firstName, String lastName,String email, String telephone, String password, String confirmPassword){

        mouseActions.sendKeys(firstNameTxt, firstName);
        mouseActions.sendKeys(lastNameTxt, lastName);
        mouseActions.sendKeys(emailTxt, email);
        mouseActions.sendKeys(telephoneTxt, telephone);
        mouseActions.sendKeys(passwordTxt, password);
        mouseActions.sendKeys(confirmPasswordTxt, confirmPassword);
        elementActions.click(checkBox);
        elementActions.click(continueBtn);

    }
}
