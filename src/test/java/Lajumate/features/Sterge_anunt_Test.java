package Lajumate.features;

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
public class Sterge_anunt_Test {

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
    String user = "liviubichescu@gmail.com";
    String password = "buburuza";
    String accountName = "Liviubichescu";
    String titleAdd = "Rotweiller mascul, 10 ani!!!";


    /**
     * Test pentru stergerea unui anunt
     */
    @Test
    public void sterge_anunt() throws InterruptedException {
        loginSteps.go_to_login_page();
        webdriver.manage().window().maximize();
        loginSteps.click_autentif();
        loginSteps.login_steps_group(user, password);
        loginSteps.should_see_account_definition(accountName);

/************************************ Pagina de account ****************************************************/
        accountSteps.show_user_meniu_click_anunturile_mele(webdriver);
        anunturileMeleSteps.check_myAdds_page("active account-myads");
        Thread.sleep(2000);
        anunturileMeleSteps.click_anunturi_active();

        //check if anunturi active page is loaded
        anunturileMeleSteps.check_anunturi_active_loaded("Anunțuri Active");
        anunturileMeleSteps.check_if_add_is_in_anunturi_active(titleAdd);
        anunturileMeleSteps.select_checkBox_for_delete();
        anunturileMeleSteps.click_sterge();
        anunturileMeleSteps.click_delete_reason_question();
        anunturileMeleSteps.submit_deactivate_popUp_reason();

        // trebuie sa verificam daca anuntul a fost sters
        anunturileMeleSteps.check_if_add_IS_NOT_present_in_active_adds(titleAdd);
        anunturileMeleSteps.click_anunturi_dezactivate();
        anunturileMeleSteps.check_anunturi_dezactivate_page("Anunțuri Dezactivate");
        anunturileMeleSteps.check_if_add_is_present_in_deactivated_adds(titleAdd);

/************************************ LOGOUT ****************************************************/
        logOutSteps.hover_user_and_logout(webdriver);
        logOutSteps.check_if_logout_is_succesful("Autentificare");

    }



}