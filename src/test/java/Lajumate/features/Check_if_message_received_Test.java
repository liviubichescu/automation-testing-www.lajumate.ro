package Lajumate.features;

import Lajumate.steps.Check_if_message_received_Steps;
import Lajumate.steps.LogoutSteps;
import Lajumate.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class Check_if_message_received_Test {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public Check_if_message_received_Steps check_if_message_received_steps;

    @Steps
    public LogoutSteps logOutSteps;

    // test fields
    private String user = "liviubichescu@gmail.com";
    private String password = "buburuza";
    private String titluAnunt = "Catelus jucaus si frumos si dragastos";
    private String messageReceived = "Acesta este ultimul mesaj de proba";


    /**
     * Test pentru cautarea unui anunt si trimiterea unui mesaj catre vanzator
     */
    @Test
    public void check_if_message_has_been_received() throws InterruptedException {
        loginSteps.go_to_login_page();
        webdriver.manage().window().maximize();
        loginSteps.click_autentif();
        loginSteps.login_steps_group(user, password);

        // click plicul cu mesaje
        check_if_message_received_steps.click_anvelope_message();
        // verificam daca am ajuns pe pagina cu mesaje
        check_if_message_received_steps.check_message_page("MESAJE PRIMITE", "MESAJE TRIMISE");
        // mergem pe mesaje primite
        check_if_message_received_steps.click_mesaje_primite();

        // verificam daca suntem pe mesaje trimise
        check_if_message_received_steps.checkText_mesaje_primite("Mesaje Primite");
        // cautam dinamic printre titluri anuntul nostru si dam click pe el
        check_if_message_received_steps.select_mesaj_in_mesaje_primite(titluAnunt);
        // verifica daca mesajul este in mesaje trimise
        check_if_message_received_steps.check_if_mesajul_este_in_mesaje_primite(messageReceived);

        logOutSteps.hover_user_and_logout(webdriver);
        logOutSteps.check_if_logout_is_succesful("Autentificare");


    }



}