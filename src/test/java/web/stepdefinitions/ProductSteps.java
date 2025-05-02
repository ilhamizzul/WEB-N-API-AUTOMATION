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
        productPage.addSelectedItemToCartList();
    }

    @Then("product is added to cart notification is shown")
    public void productIsAddedToCartNotificationIsShown() {
        productDetailPage.verifyAlertMessage("Product added");
    }

    @Then("added product exist in cart page")
    public void addedProductExistInCartPage() {
        productDetailPage.clickCartButton();

        // LATER SHOULD BE CHANGE
        cartPage.verifyPageLoaded();
        cartPage.verifyAddedProductIsInCart(productPage.getListOfSelectedItems());
        cartPage.verifyTotalPrice(productPage.getTotalPrice());
    }

    @When("user want to add {string} items on cart")
    @And("user add {string} product in cart")
    public void userWantToAddItemsOnCart(String totalItems) {
        for (int i = 0; i < Integer.parseInt(totalItems); i++) {
            userClickCertainProduct();
            userClickAddProductToCart();
            productIsAddedToCartNotificationIsShown();
            productPage.clickMainPageButton();
        }
    }

    @When("user click checkout button in cart page")
    public void userClickCheckoutButtonInCartPage() {
        productDetailPage.clickCartButton();
        cartPage.clickPlaceOrder();
        cartPage.verifyModalPurchaseLoaded();
    }

    @And("user fill the cart checkout form")
    public void userFillTheCartCheckoutForm() {
        cartPage.fillPurchaseModal("john doe", "TEST COUNTRY", "CITY", "123098", "12", "32");
    }

    @Then("purchase is successfully been made")
    public void purchaseIsSuccessfullyBeenMade() {
        cartPage.verifyModalPurchaseVisible();
    }
}
