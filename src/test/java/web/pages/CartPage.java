package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartPage extends MainPage {

    private final By btnPlaceOrder = By.xpath("//button[@data-target='#orderModal']");
    private final By tblCart = By.xpath("//table[@class='table table-bordered table-hover table-striped']");
    private final By lblTotalPrice = By.xpath("//h3[@id='totalp']");

    private final String xpathProductName = "((//tbody//tr[@class='success'])[%d]//td)[2]";
    private final String xpathProductPrice = "((//tbody//tr[@class='success'])[%d]//td)[3]";
    private final String xpathDeleteProduct = "((//tbody//tr[@class='success'])[2]//td)[4]//a";
    private final By tblCartItems = By.xpath("//tr[@class='success']");

    private final By mdlTotalPrice = By.xpath("//label[@id='totalm']");
    private final By mdlTxtName = By.xpath("//input[@id='name']");
    private final By mdlTxtCountry = By.xpath("//input[@id='country']");
    private final By mdlTxtCity = By.xpath("//input[@id='city']");
    private final By mdlTxtCreditCard = By.xpath("//input[@id='card']");
    private final By mdlTxtMonth = By.xpath("//input[@id='month']");
    private final By mdlTxtYear = By.xpath("//input[@id='year']");
    private final By mdlBtnPurchase = By.xpath("//button[@onclick='purchaseOrder()']");
    private final By mdlBtnCancel = By.xpath("//div[@id='orderModal']//button[@type='button'][@class='btn btn-secondary']");

    @Override
    public void verifyPageLoaded() {
        super.verifyPageLoaded();
        verifyElementsAreVisible(btnPlaceOrder, tblCart, lblTotalPrice);
    }

    public void verifyModalPurchaseLoaded() {
        verifyElementsAreVisible(mdlTotalPrice, mdlTxtName, mdlTxtCountry, mdlTxtCity, mdlTxtCreditCard, mdlTxtMonth, mdlTxtYear, mdlBtnPurchase, mdlBtnCancel);
    }

    public void clickPlaceOrder() {
        click(btnPlaceOrder);
    }

    public void verifyAddedProductIsInCart(List<HashMap<String, Object>> addedItems) {
        // Get product name and price from the table
        List<String> tableProductNames = new ArrayList<>();
        List<String> tableProductPrices = new ArrayList<>();
        List<WebElement> cartItems = driver.findElements(tblCartItems);

        int rowCount = cartItems.size();
        for (int i = 1; i <= rowCount; i++) {
            String productName = GetText(By.xpath(String.format(xpathProductName, i)));
            String productPrice = GetText(By.xpath(String.format(xpathProductPrice, i)));

            tableProductNames.add(productName);
            tableProductPrices.add(productPrice);
        }

        boolean allProductsFound = true;
        // Check if each addedItem exists in the table data
        for (HashMap<String, Object> addedItem : addedItems) {
            String expectedName = addedItem.get("name").toString();
            String expectedPrice = addedItem.get("price").toString();

            // Check existence in the table data
            if (!(tableProductNames.contains(expectedName) && tableProductPrices.contains(expectedPrice))) {
                allProductsFound = false;
                System.out.println("Product not found in the table: [name=" + expectedName + ", price=" + expectedPrice + "]");
            }
        }

        // check if item on carttable have equal item count with added products
        if (cartItems.size() != addedItems.size()) {
            allProductsFound = false;
            System.out.println("Item count on carttable is not match with added products");
        }

        // Verify the result
        if (allProductsFound) {
            System.out.println("All products have been successfully verified in the cart.");
        } else {
            throw new AssertionError("Some products are missing from the cart, or the data does not match!");
        }
    }

    public void verifyTotalPrice(String expectedTotalPrice) {
        String actualTotalPrice = GetText(lblTotalPrice);
        Assert.assertEquals(expectedTotalPrice, actualTotalPrice, "Total price is not match");
    }

}
