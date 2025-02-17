package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

import static browser.Config.WAIT;

public class WebForm extends BasePage {

    public WebForm(WebDriver driver) {
        super(driver);
    }

    public static final String URL_WEB_FORM = "https://idm-test.russianpost.ru/";
    public static final By BTN_DETAILS = By.xpath("//button[@id='details-button']");
    public static final By BTN_OK = By.xpath("//a[@id='proceed-link']");
    public static final By INPUT_LOGIN = By.xpath("//input[@name='username']");
    public static final By INPUT_PASSWORD = By.xpath("//input[@type='password' and @name='password' and @placeholder='Введите пароль' and @id='mat-input-1']");
    public static final By BTN_LOGIN = By.xpath("//button[contains(@class, 'mat-raised-button') and contains(@class, 'mat-accent')]");
    public static final By BTN_NEW = By.xpath("//a[contains(@class, 'new-request') and contains(@class, 'mat-stroked-button')]");
    public static final By INPUT_SEARCH = By.xpath("//input[contains(@class, 'mat-input-element') and @id='mat-input-2']");
    public static final By LV_EMPLOYEER = By.xpath("//span[contains(@class, 'highlighted') and text()='Регистрация сотрудника подрядной организации']");

    public static final By INPUT_SURNAME = By.xpath("//mat-label[text()='Фамилия']/ancestor::div[contains(@class, 'mat-form-field-infix')]//input");
    public static final By INPUT_NAME = By.xpath("//mat-label[text()='Имя']/ancestor::div[contains(@class, 'mat-form-field-infix')]//input");
    public static final By INPUT_PATRONYMIC = By.xpath("//mat-label[text()='Отчество']/ancestor::div[contains(@class, 'mat-form-field-infix')]//input");
    public static final By INPUT_PHONE = By.xpath("//mat-label[text()='Мобильный телефон']/ancestor::div[contains(@class, 'mat-form-field-infix')]//input");
    public static final By INPUT_MAIL = By.xpath("//mat-label[text()='E-mail']/ancestor::div[contains(@class, 'mat-form-field-infix')]//input[@type='text' and @autocomplete='off']");
    public static final By BTN_NEXT = By.xpath("//button[span[contains(text(), 'Далее')]]");

    public static final By CLK_FILTR = By.xpath("//mat-expansion-panel-header[.//mat-panel-title[contains(text(), 'Фильтр')]]");
    public static final By INPUT_FILTR = By.xpath("//input[contains(@class, 'mat-input-element') and @id='mat-input-3']");
    public static final By BTN_PRIMENIT = By.xpath("//button[contains(@class, 'mat-raised-button') and .//span[text()='Применить']]");
    public static final By CHECK_PODRIAD = By.xpath("//label[contains(@class, 'mat-checkbox-layout') and .//span[contains(text(), 'SistemaGorod')]]");

    public static final By INPUT_ESED = By.xpath("//input[@type='text' and @id='mat-input-5' and @aria-describedby='mat-hint-0']");
    public static final By INPUT_DOG = By.xpath("//textarea[@id='mat-input-6']");
    public static final By DTP_BLOCK = By.xpath("(//button[@aria-label='Open calendar'])[1]");
    public static final By DTP_BLOCK_ELEMENT = By.xpath("//div[contains(@class, 'mat-calendar-body-cell-content') and text()='30']");
    public static final By DTP_BLOCK_2 = By.xpath("(//button[@aria-label='Open calendar'])[2]");

    public static final By BTN_SOZDAT = By.xpath("//button[contains(@class, 'mat-raised-button') and .//span[contains(text(), 'Создать')]]");
    public static final By BTN_SOZDAT_2 = By.xpath("//button[span[text()='Создать']]");

    public WebForm openWebForm(){
        openUrl(URL_WEB_FORM);
        return new WebForm(driver);
    }

    public void setLogin(String textInput){
        sendKeys(INPUT_LOGIN, textInput);
    }

    public String getLoginValue() {
        return findElement(INPUT_LOGIN).getAttribute("value");
    }

    public void setPassword(String textInput){
        sendKeys(INPUT_PASSWORD, textInput);
    }

    public String getPasswordValue() {
        return findElement(INPUT_PASSWORD).getAttribute("value");
    }

    public void setSearch(String textInput){
        sendKeys(INPUT_SEARCH, textInput);
    }

    public String getSearchValue() {
        return findElement(INPUT_SEARCH).getAttribute("value");
    }

    public void clickDetails() {
        click(BTN_DETAILS);
    }

    public void clickOk() {
        click(BTN_OK);
    }

    public void clickLogin(){
        click(BTN_LOGIN);
    }

    public void clickNew(){
        click(BTN_NEW);
    }

    public void clickNewEmployeer(){
        click(LV_EMPLOYEER);
    }

    public void clickNext(){
        click(BTN_NEXT);
    }

    public void setInputSurname(String textInput){
        click(INPUT_SURNAME);
        sendKeys(INPUT_SURNAME, textInput);
    }

    public String getSurname(){
        return findElement(INPUT_SURNAME).getAttribute("value");
    }

    public void setInputName(String textInput){
        click(INPUT_NAME);
        sendKeys(INPUT_NAME, textInput);
    }

    public String getName(){
        return findElement(INPUT_NAME).getAttribute("value");
    }

    public void setInputPatronymic(String textInput){
        click(INPUT_PATRONYMIC);
        sendKeys(INPUT_PATRONYMIC, textInput);
    }

    public String getPatronymic(){
        return findElement(INPUT_PATRONYMIC).getAttribute("value");
    }

    public void setInputPhone(String textInput){
        click(INPUT_PHONE);
        sendKeys(INPUT_PHONE, textInput);
    }

    public String getPhone(){
        return findElement(INPUT_PHONE).getAttribute("value");
    }

    public void setInputMail(String textInput){
        click(INPUT_MAIL);
        sendKeys(INPUT_MAIL, textInput);
    }

    public String getMail(){
        return findElement(INPUT_MAIL).getAttribute("value");
    }

    public void setInputFiltr(String textInput){
        sendKeys(INPUT_FILTR, textInput);
    }

    public void clickFiltr(){
        click(CLK_FILTR);
    }

    public void clickPrimenit(){
        click(BTN_PRIMENIT);
    }

    public void clickPodriad(){
        click(CHECK_PODRIAD);
    }

    public void setInputEsed(String textInput){
        sendKeys(INPUT_ESED, textInput);
    }

    public void setInputDog(String textInput){
        click(INPUT_DOG);
        sendKeys(INPUT_DOG, textInput);
    }

    public void clickDtp1(){

        click(DTP_BLOCK);
        click(DTP_BLOCK_ELEMENT);
    }

    public void clickDtp2(){
        click(DTP_BLOCK_2);
        click(DTP_BLOCK_ELEMENT);
    }

    public void clickSozdat(){
        click(BTN_SOZDAT);
    }

    public void clickSozdat2(){
        click(BTN_SOZDAT_2);
    }
}
