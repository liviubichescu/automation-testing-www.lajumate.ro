package Lajumate.features.loginAndLogout.loginInvalid;

import Lajumate.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class Empty_email_login_Test {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Test
    public void invalid_email_login() {
        loginSteps.go_to_login_page();
        webdriver.manage().window().maximize();
        loginSteps.click_autentif();
        loginSteps.login_steps_group("", "buburuza");
        loginSteps.should_see_allert_message_for_account("Câmpul email este obligatoriu.");

    }

} 