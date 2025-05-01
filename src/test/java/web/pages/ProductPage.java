package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ProductPage extends MainPage {
    private final List<HashMap<String, Object>> addedItemToCartIndices = new ArrayList<>();
    private HashMap<String, Object> selectedItem = new HashMap<>();

    private final By divCarousel = By.xpath("//div[@data-ride='carousel']");
    private final By divCategory = By.xpath("//div[@class='list-group']");
    private final By cardProductsLocator = By.xpath("//div[@id='tbodyid']//div//div[@class='card h-100']");

    private final String xpathProductName = "(//a[@class='hrefch'])[%d]";
    private final String xpathProductPrice = "(//div[@class='card-block']//h5)[%d]";

    // randomize index of product cards
    private int randomItem(int upperIndex) {
        Random random = new Random();
        return random.nextInt(upperIndex);
    }

    // create Hashmap or object for adding to List
    private HashMap<String, Object> createSelectedItem(int index) {
        HashMap<String, Object> item = new HashMap<>();
        item.put("index", String.valueOf(index));
        item.put(
            "name", GetText(By.xpath(String.format(xpathProductName, index)))
        );
        item.put(
            "price", GetText(By.xpath(String.format(xpathProductPrice, index))).substring(1)
        );

        return item;
    }


    // to check if randomize index is already exist on the list
    private boolean isIndexAlreadyAdded(int index) {
        return addedItemToCartIndices.stream()
                .anyMatch(item -> item.get("index").equals(String.valueOf(index)));
    }


    private int selectRandomProduct() {
        List<WebElement> cardProducts = driver.findElements(cardProductsLocator);

        int index = randomItem(cardProducts.size());
        while (isIndexAlreadyAdded(index) || index == 0) {
            index = randomItem(cardProducts.size());
        }

        return index;
    }

    @Override
    public void verifyPageLoaded() {
        super.verifyPageLoaded();
        verifyElementsAreVisible(divCarousel, divCategory, cardProductsLocator);
    }

    public void clickProductCard() {
        int index = selectRandomProduct();
        selectedItem = createSelectedItem(index);
        By productCard = By.xpath(String.format(xpathProductName, index));
        click(productCard);
    }

    public void addSelectedItemToCartList() {
        addedItemToCartIndices.add(selectedItem);
        System.out.println("Added item to cart list: " + addedItemToCartIndices);
    }

    public String getTotalPrice() {
        int totalPrice = 0;
        for (HashMap<String, Object> addedItem : addedItemToCartIndices) {
            String expectedPrice = addedItem.get("price").toString();
            totalPrice += Integer.parseInt(expectedPrice);
        }
        return String.valueOf(totalPrice);
    }

    public HashMap<String, Object> getSelectedItem() {
        return selectedItem;
    }

    public List<HashMap<String, Object>> getListOfSelectedItems() {
        return addedItemToCartIndices;
    }

}
