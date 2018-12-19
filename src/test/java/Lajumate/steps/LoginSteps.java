package Lajumate.steps;

import Lajumate.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class LoginSteps {

    LoginPage loginPage;

    @Step
    public void go_to_login_page() {
        loginPage.open();
    }

    @Step
    public void click_autentif() {
        loginPage.click_autentificare();
    }

    @Step
    private void enters_username(String username) {
        loginPage.enters_username(username);
    }

    @Step
    private void enters_password(String password) {
        loginPage.enters_password(password);
    }

    @Step
    private void click_login() {
        loginPage.click_login();
    }

     //pasul de preluare de informatii din login page si dati mai departe catre pagina web
    @StepGroup
    public void login_steps_group(String username, String password) {
        enters_username(username);
        enters_password(password);
        click_login();
    }

    @Step
    public void should_see_account_definition(String definition) {
        assertThat(loginPage.should_be_in_current_directory(), hasItem(containsString(definition)));
    }

    @Step
    public void should_see_allert_message_for_account(String definition) {
        assertThat(loginPage.alert_message_for_account(), hasItem(containsString(definition)));
    }

}