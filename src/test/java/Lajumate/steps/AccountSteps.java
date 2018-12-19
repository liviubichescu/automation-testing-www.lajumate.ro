package Lajumate.steps;

import Lajumate.pages.AccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class AccountSteps {

    AccountPage accountPage;

    @Step
    public void click_new_add_button() {
        accountPage.click_add_anunt();
    }

    @Step
    public void check_adaugare_anunt_page(String message) {
        assertThat(accountPage.getTextAdaugareAnunt(), hasItem(containsString(message)));
    }

    @Step
    private void adauga_titlu(String titlu) {
        accountPage.add_titlu_anunt(titlu);
    }

    @Step
    private void adauga_descriere(String descriere) {
        accountPage.add_descriere_anunt(descriere);
    }

    @Step
    private void adauga_pret(String pret) {
        accountPage.add_pret_anunt(pret);
    }

    @Step
    private void select_currency() {
        accountPage.click_currency();
    }

    @Step
    private void clickCategorie() {
        accountPage.click_category();
    }

    @Step
    private void select_animale_agroindustrie() {
        accountPage.select_animale_agro();
    }

    @Step
    private void select_animale_companie() {
        accountPage.select_animale_companie();
    }

    @Step
    private void clickLocatie() {
        accountPage.click_locatie();
    }

    @Step
    private void clickJudet() {
        accountPage.click_judet();
    }

    @Step
    private void clickOras() {
        accountPage.click_oras();
    }

    @Step
    private void clickCaini() {
        accountPage.click_caini();
    }

    @Step
    private void clickMoreFields() {
        accountPage.click_more_fields();
    }

    @Step
    private void clickPretNegociabil() {
        accountPage.click_pret_negociabil();
    }

    @Step
    private void contact_name(String name) {
        accountPage.date_contact_name(name);
    }

    @Step
    private void contact_phone(String phone) {
        accountPage.date_contact_telefon(phone);
    }

    @Step
    private void publish_phone_option() {
        accountPage.dont_publish_phone_checkBox();
    }

    @Step
    private void terms_checkBox() {
        accountPage.terms_check_box();
    }

    @Step
    private void newsletter_checkBox() {
        accountPage.newsletter_check_box();
    }


    // 2 grupuri de pasi pentru executarea stepurilor de mai sus
    @StepGroup
    public void add_anunt_steps_group_steps(String titlu, String descriere, String pret) throws InterruptedException {
        adauga_titlu(titlu);
        adauga_descriere(descriere);
        adauga_pret(pret);
        select_currency();
        Thread.sleep(1000);
        clickCategorie();
        Thread.sleep(1000);
        select_animale_agroindustrie();
        Thread.sleep(1000);
        select_animale_companie();
        Thread.sleep(1000);
        clickLocatie();
        Thread.sleep(1000);
        clickJudet();
        Thread.sleep(1000);
        clickOras();
        Thread.sleep(1000);
        clickCaini();
        Thread.sleep(1000);
        clickMoreFields();
        Thread.sleep(1000);
        clickPretNegociabil();
        Thread.sleep(1000);

    }
    @StepGroup
    public void contact_data_owner_group_steps(String name, String phone) throws InterruptedException {
        contact_name(name);
        contact_phone(phone);
        Thread.sleep(1000);

        publish_phone_option();
        Thread.sleep(1000);

        terms_checkBox();
        Thread.sleep(1000);

        newsletter_checkBox();
        Thread.sleep(1000);


    }

    // pas pentru click butonul de submit adaugare anunt
    @Step
    public void submit_adauga_anunt() {
        accountPage.submit_adauga_anunt();
    }

    @Step
    public void check_promote_page(String message) {
        assertThat(accountPage.getTextFelicitariPentruAdaugareAnunt(), hasItem(containsString(message)));
    }

    @Step
    public void fara_promovare() {
        accountPage.click_fara_promovare();
    }

    @Step
    public void notificari_instant() {
        accountPage.notificari_instant();
    }


    // verificam daca am ajuns inapoi pe pagina de account dupa adaugarea unui anunt
    @Step
    public void check_account_page_after_add(String message) {
        assertThat(accountPage.getTextDupaAdaugareAnunt(), hasItem(containsString(message)));
    }

    // hoover peste numele userului din account pentru a aparea meniul si click pe anunturile mele
    @Step
    public void show_user_meniu_click_anunturile_mele(WebDriver webdriver) throws InterruptedException {
        accountPage.hoverAccountUser(webdriver);
    }

}