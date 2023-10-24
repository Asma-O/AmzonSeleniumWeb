package common.pages;


import common.common.Constant;
import common.common.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    // constructor
    public LoginPage(WebDriver webDriver) { super(webDriver); }


    @FindBy(id = "ap_email") private WebElement email;
    private WebElement getEmail(){return email;}

    @FindBy(xpath = "//input[@id='ap_password']") private WebElement password;
    private WebElement getPassword(){return password;}

    @FindBy(id = "continue") private WebElement continueBtn;
    private WebElement getContinueBtn(){return continueBtn;}


    @FindBy(id = "signInSubmit") private WebElement signInBtn;
    private WebElement getSignInBtn(){return signInBtn;}


    public LoginPage loginToAmazon(String username,String password) {

        waitElement(getEmail()).sendKeys(Constant.email);
        waitElement(getContinueBtn()).click();
        waitElement(getPassword()).sendKeys(Constant.password);
        waitElement(getSignInBtn()).click();
        System.out.println("Logged in successfully");
        return new LoginPage(webDriver);
    }



    }

