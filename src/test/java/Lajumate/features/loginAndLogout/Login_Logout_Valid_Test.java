package Lajumate.features.loginAndLogout;

import Lajumate.steps.LogoutSteps;
import Lajumate.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class Login_Logout_Valid_Test {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public LogoutSteps logOutSteps;

    /**
     * Test pentru verificarea valida a login - ului
     */
    @Test
    public void login_valid() {
        loginSteps.go_to_login_page();
        webdriver.manage().window().maximize();
        loginSteps.click_autentif();
        loginSteps.login_steps_group("bik_liv@yahoo.com", "buburuza");
        loginSteps.should_see_account_definition("Liv Bik");
    }

    /**
     * Test pentru verificarea valida a logout - ului
     */
    @Test
    public void logout_valid() throws InterruptedException {
        login_valid();
        logOutSteps.hover_user_and_logout(webdriver);
        logOutSteps.check_if_logout_is_succesful("Autentificare");
    }

}