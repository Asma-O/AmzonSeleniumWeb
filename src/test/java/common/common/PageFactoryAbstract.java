package common.common;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public abstract class PageFactoryAbstract {

    public PageFactoryAbstract()
    {
        this.setWebDriver(Browser.createInstance());
    }

    WebDriver _driver;

    @BeforeClass
    public WebDriver getWebDriver() {
        if (_driver == null) {
            _driver = Browser.createInstance(Constant.broswer);
        }
        return _driver;
    }

    public void setWebDriver(WebDriver driver) {
        this._driver = driver;
    }

    public void deleteAllDriverCookies()
    {
        getWebDriver().manage().deleteAllCookies();
    }


    @AfterTest
    public void CloseDriver() {
       this._driver.quit();
        this._driver = null;
    }




}