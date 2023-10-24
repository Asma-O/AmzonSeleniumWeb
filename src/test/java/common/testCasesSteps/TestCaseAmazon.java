package common.testCasesSteps;


import common.common.Constant;
import common.common.PageFactory;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestCaseAmazon {

    @Description("2- Step: Login ")
    @Test
    public void TC1_Verify_Valid_Login() throws MalformedURLException {
      PageFactory.instance().homePage().clickOnSignIn();
        PageFactory.instance().loginPage().loginToAmazon(Constant.email, Constant.password );
    }

    @Description("3- Step: Select the requested condition before adding to the cart")
    @Test(dependsOnMethods = "TC1_Verify_Valid_Login")
    public void TC2_Verify_SelectOrderCondition() throws MalformedURLException {
        PageFactory.instance().homePage().clickOnMenu()
                        .clickOnSeeAll()
                                .clickOnVideoGames()
                                        .clickOnAllVideoGames()
                                                .clickOnFreeShipping()
                                                        .clickOnNew()
                                                                .selectOrderBy();

    }


    @Description("4- Step: Adding selected items to the cart")
    @Test(dependsOnMethods ="TC2_Verify_SelectOrderCondition" )
    public void TC3_Verify_Add_Product_To_The_Cart() throws MalformedURLException {
        PageFactory.instance().homePage().selectProduct();
    }


    @Description("5- Step: Adding new address")
    @Test(dependsOnMethods ="TC3_Verify_Add_Product_To_The_Cart" )
    public void TC4_Verify_Add_New_Address() throws MalformedURLException {

        PageFactory.instance().homePage().clickOnCardCount()
                        .clickOnProceedToBuy();
        PageFactory.instance().checkOutPage().changeAddress();
        Assert.assertTrue(PageFactory.instance().checkOutPage().verifyProductAddItToCard());

    }


}
