import browser.Browser;
import browser.RandomGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.elements.WebForm;

import static pages.elements.WebForm.INPUT_SURNAME;

public class WebFormTest1 {
    private WebDriver driver;
    private WebForm webForm;

    private static final String login = "login";
    private static final String password = "password";
    private static final String search = "Регистрация сотрудника подрядной организации";
    private static final String phone = "+79876543210";
    private static final String mail = "test@mail.com";
    private static final String filtr = "SistemaGorod";
    private static final String esed = "e1cib/data/";
    private static final String dogovor = "№2345";

    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        webForm = new WebForm(driver);
    }

     @AfterTest
    public void afterTest(){
       driver.quit();
    }

    /**
     * Тест Step 1:
     */
    @Test
    public void step_1() {
        webForm.openWebForm();

        webForm.clickDetails();
        webForm.clickOk();
    }


    /**
     * Тест Step 2:
     */
    @Test
    public void step_2()  throws InterruptedException {
        webForm.setLogin(login);
        webForm.setPassword(password);

        Assert.assertEquals(webForm.getLoginValue(), login);
        Assert.assertEquals(webForm.getPasswordValue(), password);

        webForm.clickLogin();
    }

    /**
     * Тест Step 3:
     */
   @Test
    public void step_3(){
        webForm.clickNew();
    }

    /**
     * Тест Step 4:
     */
    @Test
    public void step_4(){
        webForm.setSearch(search);

        Assert.assertEquals(webForm.getSearchValue(), search);
        webForm.clickNewEmployeer();
    }

    @Test
    public void step_5() {
        String randomSurname = RandomGenerator.generateRandomLastName();
        String randomName = RandomGenerator.generateRandomFirstName();
        String randomPatronymic = RandomGenerator.generateRandomPatronymic();

        //Thread.sleep(5000); //
        // Вводим сгенерированную фамилию в соответствующее поле

        webForm.setInputSurname(randomSurname);
        webForm.setInputName(randomName);
        webForm.setInputPatronymic(randomPatronymic);


        // Проверка, что фамилия введена правильно
        Assert.assertEquals(webForm.getSurname(), randomSurname);
        Assert.assertEquals(webForm.getName(), randomName);
        Assert.assertEquals(webForm.getPatronymic(), randomPatronymic);

        webForm.setInputPhone(phone);
        webForm.setInputMail(mail);

        webForm.clickNext();
    }

    @Test
    public void step_6(){
        webForm.clickFiltr();
        webForm.setInputFiltr(filtr);
        webForm.clickPrimenit();
    }

    @Test
    public void step_7(){
        webForm.clickPodriad();
        webForm.clickNext();
    }

    @Test
    public void step_8() throws InterruptedException {
        webForm.clickDtp1();

        webForm.setInputEsed(esed);
        webForm.setInputDog(dogovor);

        webForm.clickDtp2();
        webForm.clickSozdat();
    }

    @Test
    public void step_9(){
        webForm.clickSozdat2();
    }
}
