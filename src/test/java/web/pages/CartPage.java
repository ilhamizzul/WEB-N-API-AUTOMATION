package web.pages;

import org.openqa.selenium.By;

public class CartPage extends MainPage {

    private final By btnPlaceOrder = By.xpath("//button[@data-target='#orderModal']");
    private final By tblCart = By.xpath("//table[@class='table table-bordered table-hover table-striped']");
    private final By lblTotalPrice = By.xpath("//h3[@id='totalp']");

    private final String xpathProductPrice = "((//tbody//tr[@class='success'])[%d]//td)[3]";
    private final String xpathDeleteProduct = "((//tbody//tr[@class='success'])[2]//td)[4]//a";

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


}
