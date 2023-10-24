package common.common;



import common.pages.CheckOutPage;
import common.pages.HomePage;
import common.pages.LoginPage;

import java.net.MalformedURLException;

public class PageFactory extends PageFactoryAbstract {

    private static PageFactory _pageFactory;

    public PageFactory() {
        super();
    }

    public static PageFactory instance() {
        if (_pageFactory == null) {
            _pageFactory = new PageFactory();
        }
        return _pageFactory;
    }

    // Login page
    public LoginPage loginPage() throws MalformedURLException {return new LoginPage(getWebDriver());}
    // Home page
    public HomePage homePage() throws MalformedURLException {return new HomePage(getWebDriver());}
   // Check out page
    public CheckOutPage checkOutPage() throws MalformedURLException {return new CheckOutPage(getWebDriver());}





}
