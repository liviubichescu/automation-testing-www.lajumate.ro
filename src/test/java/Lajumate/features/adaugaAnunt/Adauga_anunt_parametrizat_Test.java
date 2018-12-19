package Lajumate.features.adaugaAnunt;

import Lajumate.steps.AccountSteps;
import Lajumate.steps.AnunturileMeleSteps;
import Lajumate.steps.LoginSteps;
import Lajumate.steps.LogoutSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src\\test/resources/adaugaAnuntDATA.csv")
public class Adauga_anunt_parametrizat_Test {

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

    // test data fields
    private String user, password, accountName, titluAnunt, descriereAnunt, pret;

    /**
     * Test pentru adaugarea unui anunt si verificarea lui in sectiunea de moderare
     */
    @Test
    public void adauga_anunt() throws InterruptedException {

        loginSteps.go_to_login_page();
        webdriver.manage().window().maximize();
        loginSteps.click_autentif();
        loginSteps.login_steps_group(user,password);
        loginSteps.should_see_account_definition(accountName);

/************************************ Pagina de account ****************************************************/
        accountSteps.click_new_add_button();
        accountSteps.check_adaugare_anunt_page("Adaugă Anunţ");
        accountSteps.add_anunt_steps_group_steps(titluAnunt, descriereAnunt,pret);
        accountSteps.contact_data_owner_group_steps("Liviu Lucian", "0758642382");
        accountSteps.submit_adauga_anunt();

/************************************ Sectiunea de promovare ****************************************************/
        accountSteps.check_promote_page("Felicitări! Anunțul tău a fost adăugat și va fi verificat imediat de către un moderator.");
        Thread.sleep(5000);
        accountSteps.fara_promovare();
        accountSteps.notificari_instant();
        accountSteps.check_account_page_after_add("container_holder");
        accountSteps.show_user_meniu_click_anunturile_mele(webdriver);

/************************************ Sectiunea cu Anunturile mele ****************************************************/
        anunturileMeleSteps.check_myAdds_page("active account-myads");
        Thread.sleep(5000);
        anunturileMeleSteps.click_anunturi_moderare();
        anunturileMeleSteps.check_anunturi_moderare_load("Anunțuri în Moderare");
        anunturileMeleSteps.check_if_add_in_moderare(titluAnunt);

/************************************ LOGOUT ****************************************************/
        logOutSteps.hover_user_and_logout(webdriver);
        logOutSteps.check_if_logout_is_succesful("Autentificare");

    }


}