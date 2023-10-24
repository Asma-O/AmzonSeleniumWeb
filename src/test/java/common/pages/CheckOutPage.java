package common.pages;


import common.common.Constant;
import common.common.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase {
    // constructor
    public CheckOutPage(WebDriver webDriver) { super(webDriver); }


    @FindBy(id = "addressChangeLinkId") private WebElement changeAddress;
    private WebElement getChangeAddress(){return changeAddress;}

    @FindBy(id = "add-new-address-popover-link") private WebElement addNewAddress;
    private WebElement getAddNewAddress(){return addNewAddress;}

    @FindBy(id = "address-ui-widgets-enterAddressFullName") private WebElement fullName;
    private WebElement getFullName(){return fullName;}


    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber") private WebElement mobileNumber;
    private WebElement getMobileNumber(){return mobileNumber;}

    @FindBy(id = "address-ui-widgets-enterAddressLine1") private WebElement streetName;
    private WebElement getStreetName(){return streetName;}


    @FindBy(id = "address-ui-widgets-enter-building-name-or-number") private WebElement buildingName;
    private WebElement getBuildingName(){return buildingName;}


    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']") private WebElement city;
    private WebElement getCity(){return city;}


    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressDistrictOrCounty']") private WebElement district;
    private WebElement getDistrict(){return district;}



    @FindBy(id = "address-ui-widgets-landmark") private WebElement nearestLandmark;
    private WebElement getNearestLandmark(){return nearestLandmark;}


    @FindBy(xpath = "//input[@id='address-ui-widgets-addr-details-res-radio-input']") private WebElement addressType;
    private WebElement getAddressType(){return addressType;}


    @FindBy(xpath = "//span[@id='address-ui-widgets-form-submit-button']//input[@class='a-button-input']") private WebElement addAddress;
    private WebElement getAddAddress(){return addAddress;}

    @FindBy(id = "payChangeButtonId") private WebElement changePayment;
    private WebElement changePayment(){return addAddress;}

    @FindBy(css = ".cod-suppressed-color.a-color-secondary") private WebElement cashMethod;
    private WebElement getCashMethod(){return cashMethod;}


    @FindBy(id = "pp-PP1dKB-73-announce") private WebElement useThisPayment;
    private WebElement getUseThisPayment(){return useThisPayment;}


    @FindBy(xpath = "//span[@class='a-color-link clickable-heading']") private WebElement numOfItemsTitle;
    private WebElement getNumOfItemsTitle(){return numOfItemsTitle;}


    @FindBy(xpath = "//*[@class='a-color-price']") private WebElement totalAmount;
    private WebElement getTotalAmount(){return totalAmount;}


    @FindBy(xpath = "//tr[1]/td[@class='a-text-right aok-nowrap a-nowrap']") private WebElement actualPrice;
    private WebElement getActualPrice(){return actualPrice;}



    @FindBy(id = "a-color-success") private WebElement derFees;
    private WebElement getDerFees(){return derFees;}


public CheckOutPage changeAddress(){

        waitElement(getChangeAddress()).click();
        waitElement(getAddNewAddress()).click();
        waitElement(getFullName()).sendKeys(Constant.fullName);
        waitElement(getMobileNumber()).sendKeys(Constant.mobileNumber);
        waitElement(getStreetName()).sendKeys(Constant.streetName);
        waitElement(getBuildingName()).sendKeys(Constant.buildingName);
        waitElement(getCity()).sendKeys(Constant.city);
        waitElement(getDistrict()).sendKeys(Constant.district);
        waitElement(getNearestLandmark()).sendKeys(Constant.nearestLandmark);
        waitElement(getAddressType()).click();
        waitElement(getAddAddress()).click();
        return new CheckOutPage(webDriver);
}


    public   boolean verifyProductAddItToCard()
    {
        String [] numOfItems = waitElement(numOfItemsTitle).getText().split(" ");

        return Integer.parseInt(numOfItems[0]) == HomePage.getNumOfProduct();
    }


    }

