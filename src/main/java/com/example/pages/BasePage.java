package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Actions actions;

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    private static final Duration LONG_TIMEOUT = Duration.ofSeconds(30);

    protected BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /** Retorna el título de la página actual. */
    protected String getPageTitle() {
        return driver.getTitle();
    }

    /** Vuelve a la página anterior del historial. */
    protected void goBack() {
        driver.navigate().back();
    }

    /** Recarga la página actual. */
    protected void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * Espera a que el elemento sea visible y lo retorna.
     * Único punto de contacto con WebDriverWait + ExpectedConditions.
     */
    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /** Espera a que todos los elementos del locator sean visibles. */
    protected List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /** Espera a que el elemento sea clickeable (visible + habilitado). */
    protected WebElement findClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /** Espera hasta LONG_TIMEOUT para elementos que tardan en aparecer. */
    protected WebElement findElementLong(By locator) {
        WebDriverWait longWait = new WebDriverWait(driver, LONG_TIMEOUT);
        return longWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /** Hace clic en el elemento cuando esté clickeable. */
    protected void click(By locator) {
        findClickable(locator).click();
    }

    /**
     * Escribe texto en un campo de entrada.
     * Limpia el campo antes de escribir para evitar concatenaciones.
     */
    protected void type(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /** Simula presionar una tecla especial (ENTER, TAB, ESCAPE…). */
    protected void pressKey(By locator, Keys key) {
        findElement(locator).sendKeys(key);
    }

    /** Retorna el texto visible del elemento. */
    protected String getText(By locator) {
        return findElement(locator).getText();
    }

    /** Retorna el valor de un atributo HTML del elemento. */
    protected String getAttribute(By locator, String attribute) {
        return findElement(locator).getAttribute(attribute);
    }

    /** Retorna el valor de una propiedad CSS del elemento. */
    protected String getCssValue(By locator, String property) {
        return findElement(locator).getCssValue(property);
    }

    /** Verifica si el elemento está habilitado. */
    protected boolean isEnabled(By locator) {
        return findElement(locator).isEnabled();
    }

    /** Verifica si el elemento está seleccionado (checkbox/radio). */
    protected boolean isSelected(By locator) {
        return findElement(locator).isSelected();
    }

    /** Selecciona una opción de un <select> por texto visible. */
    protected void selectByVisibleText(By locator, String text) {
        new Select(findElement(locator)).selectByVisibleText(text);
    }

    /** Selecciona una opción de un <select> por su value. */
    protected void selectByValue(By locator, String value) {
        new Select(findElement(locator)).selectByValue(value);
    }

    /** Selecciona una opción de un <select> por su índice (base 0). */
    protected void selectByIndex(By locator, int index) {
        new Select(findElement(locator)).selectByIndex(index);
    }

    /** Mueve el cursor sobre el elemento (hover). */
    protected void hover(By locator) {
        actions.moveToElement(findElement(locator)).perform();
    }

    /** Doble clic sobre el elemento. */
    protected void doubleClick(By locator) {
        actions.doubleClick(findElement(locator)).perform();
    }

    /** Clic derecho (context menu) sobre el elemento. */
    protected void rightClick(By locator) {
        actions.contextClick(findElement(locator)).perform();
    }

    /** Arrastra un elemento y lo suelta sobre otro (drag & drop). */
    protected void dragAndDrop(By source, By target) {
        actions.dragAndDrop(findElement(source), findElement(target)).perform();
    }

    /**
     * Hace scroll hasta el elemento vía JavaScript.
     * Útil cuando el elemento está fuera del viewport.
     */
    protected void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", findElement(locator));
    }

    /** Hace clic vía JavaScript. Útil cuando el click nativo falla por overlays. */
    protected void jsClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", findElement(locator));
    }

    /** Ejecuta script JS arbitrario y retorna el resultado. */
    protected Object executeScript(String script, Object... args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script, args);
    }

    /** Espera hasta que el texto esperado aparezca en el elemento. */
    protected void waitForText(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /** Espera hasta que el elemento desaparezca del DOM. */
    protected void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /** Espera hasta que la URL contenga el fragmento indicado. */
    protected void waitForUrlContains(String urlFragment) {
        wait.until(ExpectedConditions.urlContains(urlFragment));
    }

    /** Acepta (OK) la alerta activa. */
    protected void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    /** Descarta (Cancel) la alerta activa. */
    protected void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    /** Retorna el texto de la alerta activa. */
    protected String getAlertText() {
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    /** Cambia el foco al frame identificado por su locator. */
    protected void switchToFrame(By frameLocator) {
        driver.switchTo().frame(findElement(frameLocator));
    }

    /** Regresa al contexto principal (sale de cualquier frame). */
    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    /** Cambia el foco a la ventana/tab cuyo handle se indica. */
    protected void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    /** Retorna todos los handles de ventanas/tabs abiertos. */
    protected java.util.Set<String> getAllWindowHandles() {
        return driver.getWindowHandles();
    }

    /**
     * Verifica si el elemento está presente en el DOM (sin esperar).
     * No lanza excepción si no existe — retorna false.
     */
    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Verifica si el elemento es visible en pantalla.
     * No lanza excepción — retorna false si no es visible.
     */
    protected boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("La pausa fue interrumpida", e);
        }
    }

    /**
     * Espera hasta {@code seconds} segundos a que el elemento sea clickeable.
     * No lanza excepción — retorna false si el tiempo se agota.
     * Útil para pasos opcionales que pueden estar auto-colapsados.
     */
    protected boolean isButtonClickable(By locator, int seconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Espera explícita con timeout configurable para que un elemento
     * sea clickeable. Reemplaza findClickable() cuando se necesita
     * un timeout distinto al DEFAULT (10 s).
     */
    protected void waitForClickable(By locator, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Espera AJAX: las zonas se cargan dinámicamente al seleccionar país.
     * Espera hasta que el <select> de zona contenga el texto esperado.
     */
    protected void waitForZoneToLoad(By locator, String expectedZone) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.textToBePresentInElementLocated(
                        locator, expectedZone));
    }

    /** Espera explícitamente a que el elemento sea visible. */
    protected void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
