package web.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.HashMap;

public class ProductDetailPage extends MainPage {
    private final By btnAddToCart = By.xpath("//a[normalize-space()='Add to cart']");
    private final By ttlProductName = By.xpath("//h2[@class='name']");
    private final By lblPrice = By.xpath("//h3[@class='price-container']");
    private final By divProductDescription = By.xpath("//div[@id='more-information']");


    public void verifyPageLoaded(HashMap<String, Object> data) {
        String expectedProductName = (String) data.get("name");
        String expectedProductPrice = (String) data.get("price");
        super.verifyPageLoaded();
        verifyElementsAreVisible(btnAddToCart, ttlProductName, lblPrice, divProductDescription);

        Assert.assertEquals(expectedProductName, GetText(ttlProductName), "Product name is not match");
        Assert.assertTrue(GetText(lblPrice).substring(1).contains(expectedProductPrice), "Product price is not match");
    }

    public void clickAddToCart() {
        click(btnAddToCart);
    }
}
