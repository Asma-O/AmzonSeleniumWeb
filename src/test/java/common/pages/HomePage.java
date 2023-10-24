package common.pages;


import common.common.Constant;
import common.common.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageBase {

    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    // constructor
    public HomePage(WebDriver webDriver) { super(webDriver); }
    @FindBy(xpath ="//*[@class='nav-line-1-container']")
    private WebElement signIN;
    private WebElement getSignIN(){return signIN;}

    static int numOfProduct=0;

    @FindBy(xpath = "//*[@class='hm-icon-label']") private WebElement menu;
    private WebElement getMenu(){return menu;}

    @FindBy(xpath = "//*[@class='hmenu-item hmenu-compressed-btn']") private WebElement seeAll;
    private WebElement getSeeAll(){return seeAll;}

    @FindBy(xpath = "//span[@id='desktop-ptc-button-celWidget']") private WebElement proceedToBuy;
    private WebElement getProceedToBuy(){return proceedToBuy;}


    @FindBy(xpath = "//div[text()='Video Games']") private WebElement videoGames;
    private WebElement getVideoGames(){return videoGames;}


    @FindBy(xpath = "//*[text()='All Video Games']") private WebElement allVideoGame;
    private WebElement getAllVideoGame(){return allVideoGame;}

    @FindBy(xpath = "//body/div[@id='a-page']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]") private WebElement freeShipping;
    private WebElement getFreeShipping(){return freeShipping;}

    @FindBy(xpath = "//*[text()='New']") private WebElement newBtn;
    private WebElement getNewBtn(){return newBtn;}


    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/span[2]/div[1]/h1[1]/div[1]/div[4]/div[1]/div[1]/form[1]/span[1]/span[1]") private WebElement orderBy;
    private WebElement getOrderBy(){return orderBy;}

    @FindBy(xpath = "//*[@class='a-price-whole']") private List<WebElement> price;
    private List<WebElement> getPrice(){return price;}

    @FindBy(id = "add-to-cart-button") private WebElement addToCardBtn;
    private WebElement getAddToCardBtn(){return addToCardBtn;}


    @FindBy(xpath = "//a[text()='Next']") private WebElement next;
    private WebElement getNext(){return next;}

    @FindBy(id = "nav-cart-count") private WebElement cardCount;
    private WebElement getCardCount(){return cardCount;}



    @FindBy(xpath ="//a[@id='s-result-sort-select_2']") private WebElement highToLow;
    private WebElement getHighToLow(){return highToLow;}

    public HomePage clickOnSignIn(){
        waitElement(getSignIN()).click();
        return new  HomePage(webDriver);
    }
    public HomePage clickOnMenu() {

        waitElement(getMenu()).click();
        return new HomePage(webDriver);
    }

    public HomePage clickOnSeeAll() {

        waitElement(getSeeAll()).click();
        return new HomePage(webDriver);
    }

    public HomePage clickOnVideoGames() {
        //scrollToElement(getVideoGames());
        waitElement(getVideoGames()).click();
        return new HomePage(webDriver);
    }


    public HomePage clickOnAllVideoGames() {

     //   waitElement(getAllVideoGame()).click();
        js.executeScript("arguments[0].click();", waitElement(getAllVideoGame()));
        return new HomePage(webDriver);
    }

    public HomePage clickOnFreeShipping() {

       // waitElement(getFreeShipping()).click();
        js.executeScript("arguments[0].click();", waitElement(getFreeShipping()));
        return new HomePage(webDriver);
    }

    public HomePage clickOnNew() {

       // waitElement(getNewBtn()).click();
        js.executeScript("arguments[0].click();", waitElement(getNewBtn()));
        return new HomePage(webDriver);
    }


    public HomePage selectOrderBy() {
        js.executeScript("arguments[0].click();", waitElement(getOrderBy()));
        js.executeScript("arguments[0].click();", waitElement(getHighToLow()));
        return new HomePage(webDriver);
    }
    public  HomePage selectProduct( ) {
        boolean findProduct = false;
        int priceValue = Constant.priceValue;
        do {
            List<WebElement>products= getPrice();
            for (int i = 0; i < products.size(); i++) {
                 products= getPrice();
                    newWait(1000);
                    String[] pr = products.get(i).getText().split(",|\\.") ;
                    int itemPrice = Integer.parseInt(pr[0]);
                    if ((itemPrice < priceValue&&pr.length==2) ||pr.length==1) {
                        products.get(i).click();
                        waitElement(getAddToCardBtn()).click();
                        numOfProduct++;
                        webDriver.navigate().back();
                        webDriver.navigate().back();
                        findProduct = true;

                    }

            }
            if (findProduct == false)
                waitElement(getNewBtn()).click();
        } while (!findProduct);

        return new HomePage(webDriver);
    }

    public HomePage clickOnCardCount() {
        waitElement(getCardCount()).click();
        return new HomePage(webDriver);
    }


    public HomePage clickOnProceedToBuy() {
        waitElement(getProceedToBuy()).click();
        return new HomePage(webDriver);
    }

    public static int getNumOfProduct() {
        return numOfProduct;
    }

    }

