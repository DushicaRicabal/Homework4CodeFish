package mentoringWithAhmet.bankXYZ.tests;

import mentoringWithAhmet.bankXYZ.pages.BankXyzLoginPage;
import mentoringWithAhmet.bankXYZ.pages.CustomerPage;
import org.testng.annotations.Test;

public class CustomerTest extends BankTetsBase {

    @Test
    public void validateCustomerLoginFunctionality() throws InterruptedException {


        BankXyzLoginPage loginPage = new BankXyzLoginPage(driver);
        loginPage.clickCustomerLoginButton();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.selectCustomer("Harry Potter");

    }
//      customerPage.vallidateDepositFunctionality("500");
//       customerPage.vallidateDepositFunctionality("200");
}



