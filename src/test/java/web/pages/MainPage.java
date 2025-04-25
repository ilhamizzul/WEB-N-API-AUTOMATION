package web.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MainPage extends BasePageClass {

    private static final String URL = "https://www.demoblaze.com/index.html";

    private final By navBar = By.xpath("//nav");
    private final By logoNav = By.xpath("//a[@id='nava']");
    private final By btnNavLogin = By.xpath("//a[@id='login2']");
    private final By btnNavSignup = By.xpath("//a[@id='signin2']");
    private final By btnNavHome = By.xpath("//a[@class='nav-link'][@href='index.html']");
    private final By btnNavContact = By.xpath("//a[normalize-space()='Contact']");
    private final By btnNavAboutUs = By.xpath("//a[normalize-space()='About us']");

    private final By footer = By.xpath("//footer");
    private final By footerContent = By.xpath("//div[@id='fotcont']");

    // MODAL LOGIN
    private final By mdlLogin = By.xpath("//div[@id='logInModal']");
    private final By mdlLoginTitle = By.xpath("//h5[@id='logInModalLabel']");
    private final By txtLoginUsername = By.xpath("//input[@id='loginusername']");
    private final By txtLoginPassword = By.xpath("//input[@id='loginpassword']");
    private final By btnLogin = By.xpath("//button[@onclick='logIn()']");
    private final By btnLoginCancal = By.xpath("//div[@id='logInModal']//button[@type='button'][normalize-space()='Close']");

    // MODAL SIGN UP
    private final By mdlSignUp = By.xpath("//div[@id='signInModal']");
    private final By mdlSignUpTitle = By.xpath("//h5[@id='signInModalLabel']");
    private final By txtSignUpUsername = By.xpath("//input[@id='sign-username']");
    private final By txtSignUpPassword = By.xpath("//input[@id='sign-password']");
    private final By btnSignUp = By.xpath("//button[@onclick='register()']");
    private final By btnSignUpCancal = By.xpath("//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']");

    public void navigateToMainPage() {
        navigateToPage(URL);
    }

    public void verifyPageLoaded() {
        verifyElementsAreVisible(navBar, btnNavHome, btnNavContact, btnNavAboutUs, logoNav);
        scrollByPixel(driver, 500);
        verifyElementsAreVisible(footer, footerContent);
        scrollByPixel(driver, -500);
    }

    public void verifyLoginModalLoaded() {
        verifyElementsAreVisible(mdlLogin, mdlLoginTitle, txtLoginUsername, txtLoginPassword, btnLogin, btnLoginCancal);
    }

    public void verifySignupModalLoaded() {
        verifyElementsAreVisible(mdlSignUp, mdlSignUpTitle, txtSignUpUsername, txtSignUpPassword, btnSignUp, btnSignUpCancal);
    }

    public void verifyAlertMessage(String message) {
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        alert.accept();
        Assert.assertEquals(message, actualMessage, "Alert message not match");
    }

    // LOGIN INTERACTION
    public void clickOpenModalLoginButton() {
        click(btnNavLogin);
    }

    public void fillUsernameLoginModal(String username) {
        type(txtLoginUsername, username);
    }

    public void fillPasswordLoginModal(String password) {
        type(txtLoginPassword, password);
    }

    public void clickLoginButton() {
        click(btnLogin);
    }

    public void clickCloseLoginModalButton() {
        click(btnLoginCancal);
    }

    // SIGN UP INTERACTION
    public void clickOpenModalSignupButton() {
        click(btnNavSignup);
    }

    public void fillUsernameSignupModal(String username) {
        type(txtSignUpUsername, username);
    }

    public void fillPasswordSignupModal(String password) {
        type(txtSignUpPassword, password);
    }

    public void clickSignupButton() {
        click(btnSignUp);
    }

    public void clickCloseSignupModalButton() {
        click(btnSignUpCancal);
    }


}
