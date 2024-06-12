package tests;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Checkout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.Constant.*;

public class CheckoutTest extends BaseTest {
    public static List<String> nameConfirmed = new ArrayList<>();
    public static List<String> priceConfirmed = new ArrayList<>();
    public String message="Thank you for your order!";
    public String message2="Your order has been dispatched, and will arrive just as fast as the pony can get there!";

    @Test
    @Feature("CheckoutTest")
    @Description
    public void CheckoutTest() throws Exception {
        validateInputFields();
        page.getInstance(Checkout.class).getFirstName().sendKeys(firstname);
        page.getInstance(Checkout.class).getLastName().sendKeys(lastname);
        page.getInstance(Checkout.class).getZip().sendKeys(Zip);
        page.getInstance(Checkout.class).getContinue().click();

        System.out.println(cartAddTest.titleTexts);
        System.out.println(cartAddTest.titles);
        System.out.println(cartAddTest.prices);
        System.out.println(cartAddTest.priceTexts);

    }
    @Test
    @Feature("checkoutOverview")
    @Description
    public void checkoutOverview() throws Exception{

        nameConfirmed.addAll(page.getInstance(Checkout.class).getconfirmTitle().stream().map(WebElement::getText).collect(Collectors.toList()));
        priceConfirmed.addAll(page.getInstance(Checkout.class).getconfirmPrice().stream().map(WebElement::getText).collect(Collectors.toList()));
        SoftAssert softAssert = new SoftAssert();
        for(String title: nameConfirmed){
            for(String compareTitle:cartAddTest.titleTexts){
                if (title.equals(compareTitle)){
                    softAssert.assertEquals(compareTitle,title);
                    break;}
            }
            Assert.assertTrue(true, "Match found for title: " + title);}
        for(String price: priceConfirmed){
            for(String comparePrice:cartAddTest.titles){
                if (price.equals(comparePrice)){
                    softAssert.assertEquals(comparePrice,price);
                    break;}
            }
            Assert.assertTrue(true, "Match found for title: " + price);}
        softAssert.assertAll();
        page.getInstance(Checkout.class).getFinish().click();
        String currentText=page.getInstance(Checkout.class).getConfirmMEssage().getText();
        String currentText2=page.getInstance(Checkout.class).getConfirmMEssage2().getText();

        Assert.assertEquals(currentText, message, "Message mismatch");
        Assert.assertEquals(currentText2, message2, "Message mismatch");
    }

    public void validateInputFields() throws Exception {

        page.getInstance(Checkout.class).getFirstName().clear();
        page.getInstance(Checkout.class).getLastName().clear();
        page.getInstance(Checkout.class).getZip().clear();
        page.getInstance(Checkout.class).getContinue().click();
        Assert.assertTrue(page.getInstance(Checkout.class).getError(), "Error for empty fields");

        page.getInstance(Checkout.class).getFirstName().clear();
        page.getInstance(Checkout.class).getLastName().clear();
        page.getInstance(Checkout.class).getZip().clear();
    }
}