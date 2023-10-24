package common.common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PageBase {
    private static final int ELEMENT_WAIT_PERIOD_SECS = 60;
    protected WebDriver webDriver;
    private WebDriverWait _wait;
    private static int count = 0;

    public PageBase(WebDriver webDriver) {
        this.webDriver = webDriver;
        _wait = new WebDriverWait(webDriver, Duration.of(ELEMENT_WAIT_PERIOD_SECS, TimeUnit.SECONDS.toChronoUnit()));
        PageFactory.initElements(this.webDriver, this);

    }
    /**
     * @param element Web Element
     * @param Value   String value
     */
    public void sendKeyCharByChar(WebElement element, String Value) {
        for (int i = 0; i < Value.length(); i++) {
            element.sendKeys(String.valueOf(Value.charAt(i)));
        }

    }

    /**
     * @param element Maximum wait = 30 seconds
     * @return wait.until(ExpectedConditions.elementToBeClickable ( element));
     */
    public WebElement waitElement(WebElement element) {
        return _wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * @param element Maximum wait = 30 seconds
     * @return wait.until(ExpectedConditions.elementToBeClickable ( element));
     */
    public WebElement waitElementVisible(WebElement element) {
        return _wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isClickable(WebElement element)
    {
        try{
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.of(6, TimeUnit.SECONDS.toChronoUnit()));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


    /**
     * @param element Web Element
     * @param seconds Maximum wait for visibility of web element
     * @return
     */
    public WebElement waitElement(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.of(seconds, TimeUnit.SECONDS.toChronoUnit()));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Refresh the current page
     */
    public void refresh() {
        webDriver.navigate().refresh();
    }

    /**
     * Open new tab in browser
     */
    public void OpenNewTab() {
        webDriver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");
    }

    public void SwitchingToTheNextTab() {
        webDriver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "" + Keys.TAB);
    }

    public void CloseTheTap() {
        webDriver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "w");
    }

    public void SwitchingToThePreviousTab() {
        webDriver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "" + Keys.SHIFT + "" + Keys.TAB);
    }

    /**
     * Close the webDriver
     */
    public void CloseDriver() {
        webDriver.quit();
    }


    /**
     * @param element Maximum wait = 30 seconds
     * @return wait.until(ExpectedConditions.elementToBeClickable ( element));
     */
    public WebElement waitElementClick(WebElement element) {
        return _wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitTillElementNotVisisble(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.of(ELEMENT_WAIT_PERIOD_SECS, TimeUnit.SECONDS.toChronoUnit()));
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement waitPresenceOfElementLocated(WebElement element) {
        return _wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }


    /**
     * Scroll Down
     */

    public void scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,250)", "");
    }

    /**
     * Scroll up
     */

    public void scrollUp(){
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,-250)", "");
    }

    /*
     * Maximize page
     */

    public void maximizeWindow(){
        webDriver.manage().window().maximize();
    }

    /*
     * fullscreen Window
     */

    public void fullscreenWindow(){
        webDriver.manage().window().fullscreen();
    }

    /*
     * Get current URL
     */
    public void getCurrnetURL(){
        webDriver.getCurrentUrl();
    }

    /*
     * Get Title
     */
    public void getTitlePage(){
        webDriver.getTitle();
    }


    /**
     * @param value for the element
     *  To get element by text
     */
    public static WebElement getTextViewByValueForWeb(WebDriver webDriver, String value) {
        try {
            List<WebElement> elements = webDriver.findElements(By.xpath("//*[@id=\"status\"]/div[2]"));
            for (WebElement element: elements) {
                try {
                    if (element.getText().equals(value)) {
                        System.out.println("eleeeeeee "+element);
                        return (WebElement) element;
                    }
                } catch(StaleElementReferenceException e) {
                    continue;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    //Wait Wrapper Method for visibility
    public  void waitVisibility(By elementBy)  {
        _wait=new WebDriverWait(webDriver, Duration.of(100, TimeUnit.SECONDS.toChronoUnit()));
        _wait.until(ExpectedConditions.elementToBeClickable(elementBy));

    }
    //Click Method
    public  void click (By elementBy, String logText) {

        waitVisibility(elementBy);
        WebElement element = webDriver.findElement(elementBy);
        element.click();
        System.out.println(logText);
        newWait(7000);
    }
    //ClickBy javascript Method
    public  void scrollToElement (WebElement element) {

        //waitVisibility(elementBy);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", element);

        newWait(1000);

    }

    public  void clickByAction(By elementBy, String logText) {
        WebElement element = webDriver.findElement(elementBy);
        Actions builder = new Actions(webDriver);
        builder.moveToElement(element).click(element);
        builder.perform();
        System.out.println("click action");
    }

    //CheckElement is 	layed
    public  boolean elementDisplayed(By elementBy, String logText) {
        try {
            WebElement element = webDriver.findElement(elementBy);

            System.out.println(logText);

            return true;
        }
        catch(org.openqa.selenium.NoSuchElementException e)
        {
            return false;
        }
    }
    //writeText Method
    public  void writeText(By elementBy, String logText,String Text) {

        waitVisibility(elementBy);
        WebElement element = webDriver.findElement(elementBy);
        element.sendKeys(Text);
        System.out.println(logText);
        newWait(7000);

    }
    //writeText Method
    public  void writeSearchText(By elementBy, String logText,String Text) {

        waitVisibility(elementBy);
        WebElement element = webDriver.findElement(elementBy);
        element.sendKeys(Text);
        element.sendKeys(Keys.ENTER);
        System.out.println(logText);
        newWait(7000);

    }
    //submit Method
    public  void submit(By elementBy, String logText) {

        waitVisibility(elementBy);
        WebElement element = webDriver.findElement(elementBy);
        element.submit();
        System.out.println(logText);
        newWait(7000);

    }
    //get text Method
    public  String getText(By elementBy, String logText) {

        waitVisibility(elementBy);
        WebElement element = webDriver.findElement(elementBy);
        System.out.println(logText);
        return element.getText();

    }

    //random number
    public static int getRandomNo(int Range) {
        Random rand = new Random(); //instance of random class
        int int_random = rand.nextInt(Range)+1;
        return int_random;
    }

    public  void scroll() {
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("scroll(0,500);");
        newWait(7000);
    }


    public  void scrolltoElement(WebElement elementBy) {
       // WebElement element = webDriver.findElement(elementBy);
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("arguments[0].scrollIntoView();", elementBy);
        newWait(3000);
    }


    public static  void newWait(int Time) {
        try {
            Thread.sleep(Time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public  void backBtn() {
        webDriver.navigate().back();
        newWait(7000);
    }

    public String givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        System.out.println(generatedString);
        return generatedString;
    }



}
