package Lajumate.features.adaugaAnunt;

import Lajumate.steps.AccountSteps;
import Lajumate.steps.AnunturileMeleSteps;
import Lajumate.steps.LogoutSteps;
import Lajumate.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class Adauga_anunt_Test {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public AccountSteps accountSteps;

    @Steps
    public AnunturileMeleSteps anunturileMeleSteps;

    @Steps
    public LogoutSteps logOutSteps;

    // test fields
    private String user = "liviubichescu@gmail.com";
    private String password = "buburuza";
    private String accountName = "Liviubichescu";
    private String titluAnunt = "Caine Masitf de tibet frumos si sanatos";
    private String descriereAnunt = "Un caine tenace si distant dar totodata inteligent si protectiv";
    private String pret = "3000";

    /**
     * Test pentru adaugarea unui anunt si verificarea lui in sectiunea de moderare
     */
    @Test
    public void adauga_anunt() throws InterruptedException {

        loginSteps.go_to_login_page();
        Thread.sleep(2000);
        webdriver.manage().window().maximize();
        loginSteps.click_autentif();
        loginSteps.login_steps_group(user,password);
        loginSteps.should_see_account_definition(accountName);

/************************************ Pagina de account ****************************************************/
        accountSteps.click_new_add_button();
        Thread.sleep(2000);
        accountSteps.check_adaugare_anunt_page("Adaugă Anunţ");
        Thread.sleep(2000);
        accountSteps.add_anunt_steps_group_steps(titluAnunt, descriereAnunt,pret);
        accountSteps.contact_data_owner_group_steps("Liviu Lucian", "0758642382");
        accountSteps.submit_adauga_anunt();


/************************************ Sectiunea de promovare ****************************************************/
        accountSteps.check_promote_page("Felicitări! Anunțul tău a fost adăugat și va fi verificat imediat de către un moderator.");
        Thread.sleep(2000);
        accountSteps.fara_promovare();
        Thread.sleep(2000);
        accountSteps.notificari_instant();
        Thread.sleep(2000);
        accountSteps.check_account_page_after_add("container_holder");
        accountSteps.show_user_meniu_click_anunturile_mele(webdriver);

/************************************ Sectiunea cu Anunturile mele ****************************************************/
        anunturileMeleSteps.check_myAdds_page("active account-myads");
        Thread.sleep(2000);
        anunturileMeleSteps.click_anunturi_moderare();
        Thread.sleep(2000);
        anunturileMeleSteps.check_anunturi_moderare_load("Anunțuri în Moderare");
        anunturileMeleSteps.check_if_add_in_moderare(titluAnunt);

/************************************ LOGOUT ****************************************************/
        logOutSteps.hover_user_and_logout(webdriver);
        logOutSteps.check_if_logout_is_succesful("Autentificare");

    }


}