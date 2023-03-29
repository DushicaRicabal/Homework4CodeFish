package mentoringWithAhmet.bankXYZ.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;
public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#userSelect")
    WebElement customers;
    @FindBy(xpath ="//button[@class='btn btn-default']" )
    WebElement loginbutton;
    @FindBy(xpath = "/strong[contains(text(),'Welcome')]")
    WebElement headerMessage;
    @FindBy(xpath = "/button[contains(@ng-click,'deposit()')]")
    WebElement depositTop;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositBottom;
    @FindBy(xpath = "//span[.='Deposit Successful']")
    WebElement depostiMessage;

    public void selectCustomer(String name) throws InterruptedException {

        BrowserUtils.selectBy(customers, name, "text");
        Thread.sleep(1000);
        loginbutton.click();
    }
    public String validateWelcomeMessage(String expectedMessage){

        return BrowserUtils.getText(headerMessage);
    }
    public void vallidateDepositFunctionality(String amount, String expectedMessage) throws InterruptedException {
        depositTop.click();
        Thread.sleep(2000);
        this.amount.sendKeys(amount);
        Thread.sleep(1000);
        depositBottom.click();
        Assert.assertEquals(BrowserUtils.getText(depostiMessage),expectedMessage);
    }
}


