package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static browser.Config.EXPLICIT_WAIT;

/**
 * Базовый класс для всех страниц. Содержит основные методы для работы с элементами страницы.
 */
public class BasePage {
    protected WebDriver driver; // Экземпляр WebDriver для управления браузером

    // Конструктор, инициализирующий драйвер
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Константы для использования XPath локаторов на страницах
    //public static final By HEADER_XPATH = By.xpath("//header/a[@href='https://demoqa.com'][img[@src='/images/Toolsqa.jpg']]");
    //public static final String CHECK_BOX_INPUT_XPATH = "//input[@type='checkbox'][following-sibling::span[text()='%s']]";
    //public static final String CHECK_BOX_XPATH = CHECK_BOX_INPUT_XPATH + "/following-sibling::span[@class='rct-checkbox']";
    public static final By NAME_PAGE = By.xpath("//h1[@class='display-6']");
    public static final String BUTTON_XPATH = "//*[@type='button' and text()='%s']";

    // Открытие указанного URL в браузере
    public void openUrl(String url) {
        driver.get(url);
    }

    // Поиск элемента по локатору и прокрутка к нему
    public WebElement findElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element); // Скролл к элементу
        return element;
    }

    // Поиск нескольких элементов по локатору
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    // Ожидание видимости элемента на странице (неявное ожидание)
    public void waitElementIsVisible(By locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(ExpectedConditions.visibilityOf(findElement(locator)));
    }

    // Ожидание отображения элемента
    public void waitElementIsDisplay(By locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(d -> isElementDisplay(locator));
    }

    // Ожидание доступности элемента (активен)
    public void waitForElementsEnabled(By locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(d -> isElementEnabled(locator));
    }

    // Ожидание видимости элемента с использованием стандартного времени ожидания
    public void waitElementIsVisible(By locator) {
        waitElementIsVisible(locator, EXPLICIT_WAIT);
    }

    // Клик по элементу
    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // Двойной клик по элементу
    public void doubleClick(By locator) {
        Actions actions = new Actions(driver);
        actions.doubleClick(findElement(locator)).perform();
    }

    // Контекстный клик (правой кнопкой мыши) по элементу
    public void contextClick(By locator) {
        Actions actions = new Actions(driver);
        actions.contextClick(findElement(locator)).perform();
    }

    // Очистка поля ввода
    public void clear(By locator) {
        findElement(locator).clear();
    }

    // Ввод текста в элемент (например, поле ввода)
    public void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    // Очистка и ввод текста в элемент
    public void sendKeysWithClear(By locator, String text) {
        clear(locator);
        sendKeys(locator, text);
    }

    // Получение текста элемента
    public String getText(By locator) {
        return findElement(locator).getText();
    }

    // Проверка, отображается ли элемент на странице
    public boolean isElementDisplay(By locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    // Проверка, активен ли элемент
    public boolean isElementEnabled(By locator) {
        return findElement(locator).isEnabled();
    }

   /* // Проверка отображения заголовка
    public boolean isHeaderDisplayed() {
        return isElementDisplay(HEADER_XPATH);
    }*/

    // Получение количества элементов, найденных по локатору
    public int getElementsCount(By locator) {
        return findElements(locator).size();
    }

    /*// Получение состояния чекбокса (отмечен или нет)
    public boolean getCheckBoxState(String checkBoxName) {
        return findElement(By.xpath(String.format(CHECK_BOX_INPUT_XPATH, checkBoxName))).isSelected();
    }*/

    /*
     * Переводит чекбокс в нужное состояние
     * @param checkBoxName - Название чекбокса
     * @param state - состояние чекбокса (true - отмечен, false - не отмечен)
     */
    /*public void setCheckBox(String checkBoxName, boolean state) {
        if (getCheckBoxState(checkBoxName) != state) {
            click(By.xpath(String.format(CHECK_BOX_XPATH, checkBoxName)));
        }
    }*/

    // Получение состояния радиокнопки (выбрана или нет)
    public boolean getRadioButtonState(By locator) {
        return findElement(locator).isSelected();
    }

    // Установка радиокнопки
    public void setRadioButton(By locator) {
        click(locator);
    }

    /*// Создание локатора на основе типа (ID, XPATH, CSS и т.д.)
    public By locatorBuild(String textLocator, LocatorsType locatorsType) {
        By locator = null;
        switch (locatorsType) {
            case ID:
                locator = By.id(textLocator);
                break;
            case XPATH:
                locator = By.xpath(textLocator);
                break;
            case CSS:
                locator = By.cssSelector(textLocator);
                break;
            case NAME:
                locator = By.name(textLocator);
                break;
            case TAG_NAME:
                locator = By.tagName(textLocator);
                break;
            case CLASS_NAME:
                locator = By.className(textLocator);
            default:
                System.out.println("Некорректный тип селектора: " + locatorsType);
        }
        return locator;
    }*/

    // Метод для выброса ошибки
    public void failure() {
        throw new AssertionError();
    }

    // Получение имени страницы
    public String getPageName() {
        return getText(NAME_PAGE);
    }

    // Клик по кнопке на странице
    public void buttonClick(String buttonName) {
        click(By.xpath(String.format(BUTTON_XPATH, buttonName)));
    }

    // Получение значения атрибута элемента
    public String getAttributeValue(By locator, String attribute) {
        return findElement(locator).getCssValue(attribute);
    }


}
