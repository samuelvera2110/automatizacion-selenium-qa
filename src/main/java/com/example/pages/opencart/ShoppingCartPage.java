    package com.example.pages.opencart;

    import com.example.pages.BasePage;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;

    import java.util.List;
    import java.util.stream.Collectors;

    public class ShoppingCartPage extends BasePage {
        private final By breadcrumbCart = By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'Shopping Cart')]");

        private final By allProductNames = By.xpath("//div[@class='table-responsive']//tbody/tr/td[2]/a");

        private final By checkoutButton = By.linkText("Checkout");

        public ShoppingCartPage() {
            super();
        }

        public List<String> getAllProductNames() {
            List<WebElement> elements = findElements(allProductNames);
            return elements.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
        }

        public boolean isAtCartPage() {
            return findElement(breadcrumbCart).isDisplayed();
        }

        public void clickCheckout() {
            click(checkoutButton);
        }

    }
