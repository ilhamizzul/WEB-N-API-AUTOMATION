package web.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.pages.CartPage;
import web.pages.ProductDetailPage;
import web.pages.ProductPage;

import java.util.HashMap;

public class ProductSteps {
    ProductPage productPage = new ProductPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    CartPage cartPage = new CartPage();

    @Then("product page component is loaded properly")
    public void productPageLoaded() {
        productPage.verifyPageLoaded();
    }

    @When("user click certain product")
    public void userClickCertainProduct() {
        productPage.clickProductCard();
    }

    @Then("detail product page is shown")
    public void detailProductPageIsShown() {
        HashMap<String, Object> expectedProduct = productPage.getSelectedItem();
        productDetailPage.verifyPageLoaded(expectedProduct);
    }

    @And("user click add product to cart")
    public void userClickAddProductToCart() {
        productDetailPage.clickAddToCart();
    }

    @Then("product is added to cart notification is shown")
    public void productIsAddedToCartNotificationIsShown() {
        productDetailPage.verifyAlertMessage("Product added");
    }

    @And("added product exist in cart page")
    public void addedProductExistInCartPage() {
        productDetailPage.clickCartButton();
        // LATER SHOULD BE CHANGE
        cartPage.verifyPageLoaded();
    }
}
