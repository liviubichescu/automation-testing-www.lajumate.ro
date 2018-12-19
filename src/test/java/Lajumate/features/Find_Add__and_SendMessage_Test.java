package Lajumate.features;

import Lajumate.steps.Find_Add_SendMessage_Steps;
import Lajumate.steps.LogoutSteps;
import Lajumate.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class Find_Add__and_SendMessage_Test {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public Find_Add_SendMessage_Steps find_add_sendMessage_steps;


    // test fields
    private String user = "bik_liv@yahoo.com";
    private String password = "buburuza";
    private String titluAnunt = "Catelus jucaus si frumos si dragastos";
    private String accountName = "Liv Bik";
    private String mesajContent = "Acesta este ultimul ultimului mesaj de proba";



    /**
     * Test pentru cautarea unui anunt si trimiterea unui mesaj catre vanzator
     */
    @Test
    public void cauta_anunt() throws InterruptedException {
        // ma autentific si verificc daca m-am autentificat cu succes
        loginSteps.go_to_login_page();
        webdriver.manage().window().maximize();
        loginSteps.click_autentif();
        loginSteps.login_steps_group(user, password);
        loginSteps.should_see_account_definition(accountName);

/********************************* caut anuntul care ma intereseaza ***********************************************/
        //introducem datele in bara de cautare
        find_add_sendMessage_steps.search_add(titluAnunt);
        // dam click pe cauta
        find_add_sendMessage_steps.click_cauta();
        // ne asiguram ca s-a facut cautarea cu succes a titlului pe care il dorim
        find_add_sendMessage_steps.check_cautare_efectuata_cu_succes(titluAnunt);
        // cautam in pagina printre anunturi sa vedem daca se potriveste vre-unul titlului nostru si facem click pe el
        find_add_sendMessage_steps.click_anunt_gasit_step(titluAnunt);
        // verificam daca s-a deschis pagina cu anuntul dorit
        find_add_sendMessage_steps.check_anunt_incarcat_cu_succes("Catelus jucaus si frumos si dragastos");
    }

    /**
     * Test pentru trimiterea unui mesaj catre vanzator
     */
    @Test
    public void trimite_mesaj() throws InterruptedException {

        cauta_anunt();

        // click pe butonul trimitere mesaj
        find_add_sendMessage_steps.click_trimiteMesaj();
        Thread.sleep(2000);
        // scriem un mesaj
        find_add_sendMessage_steps.write_message(mesajContent);
        // click nu sunt robot checkbox se face manual
        find_add_sendMessage_steps.click_send_msg();
        Thread.sleep(2000);
        // click plicul cu mesaje
        find_add_sendMessage_steps.click_anvelope_message();
        // verificam daca am ajuns pe pagina cu mesaje
        find_add_sendMessage_steps.check_message_page("MESAJE PRIMITE", "MESAJE TRIMISE");
        Thread.sleep(2000);
        // mergem pe mesaje trimise
        find_add_sendMessage_steps.click_mesaje_trimise();
        Thread.sleep(2000);
        // verificam daca suntem pe mesaje trimise
        find_add_sendMessage_steps.checkText_mesaje_trimise("Mesaje Trimise");
        Thread.sleep(2000);
        // cautam dinamic printre titluri anuntul nostru si dam click pe el
        find_add_sendMessage_steps.select_mesaj_in_mesaje_trimise("Catelus jucaus si frumos si dragastos");
        Thread.sleep(2000);
        // verifica daca mesajul este in mesaje trimise
        find_add_sendMessage_steps.check_if_mesajul_este_in_mesaje_trimise(mesajContent);
        Thread.sleep(5000);

    }


}