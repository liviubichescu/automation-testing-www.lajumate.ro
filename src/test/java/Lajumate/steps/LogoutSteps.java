package Lajumate.steps;

import Lajumate.pages.LogOutPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class LogoutSteps {

    LogOutPage logOutPage;

    @Step
    public void hover_user_and_logout(WebDriver webdriver) throws InterruptedException {
        logOutPage.hoverUserAndLogout(webdriver);
    }


    @Step
    public void check_if_logout_is_succesful(String message) {
        assertThat(logOutPage.check_if_logout_is_succes(), hasItem(containsString(message)));
    }


}