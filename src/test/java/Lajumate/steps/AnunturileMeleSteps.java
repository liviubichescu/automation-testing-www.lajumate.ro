package Lajumate.steps;

import Lajumate.pages.AnunturileMelePage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class AnunturileMeleSteps {

    AnunturileMelePage anunturileMelePage;

    @Step
    public void check_myAdds_page(String message) {
        assertThat(anunturileMelePage.check_anunturile_mele_page(), hasItem(containsString(message)));
    }

    @Step
    public void click_anunturi_moderare() {
        anunturileMelePage.click_anunturi_in_moderare();
    }

    @Step
    public void check_anunturi_moderare_load(String message) {
        assertThat(anunturileMelePage.check_anunturi_moderare_loading(), hasItem(containsString(message)));
    }

    @Step
    public void check_if_add_in_moderare(String message) {
        assertThat(anunturileMelePage.check_if_add_is_in_moderare(), hasItem(containsString(message)));
    }


    /******************************* partea de stergere anunt *****************************************************/

    @Step
    public void click_anunturi_active() {
        anunturileMelePage.click_anunturi_active();
    }

    @Step
    public void check_anunturi_active_loaded(String message) {
        assertThat(anunturileMelePage.check_if_anunturi_active_loaded(), hasItem(containsString(message)));
    }

    @Step
    public void check_if_add_is_in_anunturi_active(String message) {
        assertThat(anunturileMelePage.check_if_add_is_in_anunturi_active(), hasItem(containsString(message)));
    }


    @Step
    public void select_checkBox_for_delete() {
        anunturileMelePage.click_checkBox_for_delete();
    }

    @Step
    public void click_sterge() {
        anunturileMelePage.click_dezactiveaza();
    }

    @Step
    public void click_delete_reason_question() {
        anunturileMelePage.click_delete_reason();
    }

    @Step
    public void submit_deactivate_popUp_reason() {
        anunturileMelePage.submit_deactivate_popUp_reason();
    }

    /******************************* partea de verificare a stergerii unui anunt *****************************************************/

    @Step
    public void check_if_add_IS_NOT_present_in_active_adds(String message) {
        assertThat(anunturileMelePage.check_if_add_not_present_in_active_adds(), not(hasItem(containsString(message))));
    }

    @Step
    public void click_anunturi_dezactivate() {
        anunturileMelePage.click_anunturi_dezactivate();
    }

    @Step
    public void check_anunturi_dezactivate_page(String message) {
        assertThat(anunturileMelePage.check_anunturi_moderare_loading(), hasItem(containsString(message)));
    }

    @Step
    public void check_if_add_is_present_in_deactivated_adds(String message) {
        assertThat(anunturileMelePage.check_if_add_is_present_in_deactivated(), hasItem(containsString(message)));
    }

}