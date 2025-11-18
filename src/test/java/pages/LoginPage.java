package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class LoginPage {
    @FindBy(css="input#user-name")
    WebElement userName;

    @FindBy(xpath="//input[@data-test='password']")
    WebElement password;

    @FindBy(css="input[type='submit']")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public HomePage login(String uName,String pwd){
        userName.sendKeys(uName);
        password.sendKeys(pwd);
        loginBtn.click();
        return new HomePage();
    }

    public String getTitle(){
        return DriverFactory.getDriver().getTitle();
    }
}
