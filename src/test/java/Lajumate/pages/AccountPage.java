package Lajumate.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

// pagina pentru a verifica daca am trecut de pagina de login cu succes
public class AccountPage extends PageObject {

    // click pe butonul de adauga anunt
    @FindBy(xpath = "//*[@id=\"header_holder\"]/header/div[2]/a")
    private WebElementFacade newAdLinkButton;
    public void click_add_anunt() {
        newAdLinkButton.click();
    }


    // verifica daca am ajuns pe pagina de adauga anunt
    public List<String> getTextAdaugareAnunt() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("h1")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // adauga titlu
    @FindBy(name = "title")
    private WebElementFacade titlu_anunt;

    public void add_titlu_anunt(String titlu) {
        titlu_anunt.type(titlu);
    }

    // adauga descriere anunt
    @FindBy(id = "description")
    private WebElementFacade descriere_anunt;

    public void add_descriere_anunt(String descriere) {
        descriere_anunt.type(descriere);
    }

    // adauga pret anunt
    @FindBy(name = "price")
    private WebElementFacade pret_anunt;

    public void add_pret_anunt(String pret) {
        pret_anunt.type(pret);
    }

    @FindBy(xpath = "//*[@id=\"euro_holder\"]")
    private WebElementFacade select_currency;

    public void click_currency() {
        select_currency.click();
    }

    // click categorie
    @FindBy(id = "cat_fake_label")
    private WebElementFacade click_categorie;

    public void click_category() {
        click_categorie.click();
    }

    // click animale_agro_industrie
    @FindBy(id = "categ_name_9")
    private WebElementFacade select_animale_agro_industrie;

    public void select_animale_agro() {
        select_animale_agro_industrie.click();
    }

    // click animale_de_companie
    @FindBy(id = "categ_name_50")
    private WebElementFacade select_animale;

    public void select_animale_companie() {
        select_animale.click();
    }

    // click locatie
    @FindBy(id = "label_location")
    private WebElementFacade click_locatie;

    public void click_locatie() {
        click_locatie.click();
    }

    // click judet
    @FindBy(id = "title_13")
    private WebElementFacade click_judet;

    public void click_judet() {
        click_judet.click();
    }

    // click oras
    @FindBy(id = "title_city_2751")
    private WebElementFacade click_oras;

    public void click_oras() {
        click_oras.click();
    }

    // click oras
    @FindBy(id = "terms")
    private WebElementFacade accept_terms;

    public void click_accept_terms() {
        accept_terms.click();
    }

    // select caini
    @FindBy(xpath = "//*[@id=\"type\"]/option[2]\n")
    private WebElementFacade chose_dogs;

    public void click_caini() {
        chose_dogs.click();
    }

    // click mai multe filtre
    @FindBy(id = "more-fields")
    private WebElementFacade more_fields;

    public void click_more_fields() {
        more_fields.click();
    }

    // select patrat pret negociabil
    @FindBy(id = "negotiable_holder")
    private WebElementFacade pret_negociabil;

    public void click_pret_negociabil() {
        pret_negociabil.click();
    }

    // adauga numele de contact
    @FindBy(id = "owner_name")
    private WebElementFacade date_contact_nume;

    public void date_contact_name(String name) {
        date_contact_nume.type(name);
    }

    // adauga telefonul de contact
    @FindBy(id = "owner_phone")
    private WebElementFacade date_contact_telefon;

    public void date_contact_telefon(String telefon) {
        date_contact_telefon.type(telefon);
    }

    // select patrat precum ca telefonul nu va fi publicat in anunt
    @FindBy(id = "owner_hide_phone_holder")
    private WebElementFacade publish_phone;

    public void dont_publish_phone_checkBox() {
        publish_phone.click();
    }

    // select patrat precum ca sunt de accord cu conditiile
    @FindBy(id = "terms_holder")
    private WebElementFacade terms;

    public void terms_check_box() {
        terms.click();
    }

    // select patrat precum ca nu doresc sa ma abonez la newsletter
    @FindBy(id = "nl_holder")
    private WebElementFacade newsletter;

    public void newsletter_check_box() {
        newsletter.click();
    }

    // click submit_adauga_anunt
    @FindBy(id = "insert_new")
    private WebElementFacade submit_adauga_anunt;

    public void submit_adauga_anunt() {
        submit_adauga_anunt.click();
    }


    // verifica daca am ajuns pe pagina de felicitari si promovarea a anuntului
    public List<String> getTextFelicitariPentruAdaugareAnunt() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("h1")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // click nu vreau promovare
    @FindBy(id = "abort_promo")
    private WebElementFacade fara_promovare;

    public void click_fara_promovare() {
        fara_promovare.click();
    }

    // click fara notificari instant
    @FindBy(xpath = "//*[@id=\"fcm_holder\"]/a")
    private WebElementFacade fara_notificari_instant;

    public void notificari_instant() {
        fara_notificari_instant.click();
    }


    // verificam daca am ajuns cu succes inapoi pe pagina de account dupa adaugarea unui anunt
    // verificarea o facem prin gasirea div-ului corespunzator meniului de search-bar
    public List<String> getTextDupaAdaugareAnunt() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("div")).stream()
                .map(element -> element.getAttribute("id"))
                .collect(Collectors.toList());
    }

    // functie care face hover pe account ca sa ne apara meniul si apoi click pe "Anunturile mele"
    @FindBy(xpath = "//*[@id=\"account_menu_link\"]")
    private WebElementFacade user_menu;

    public void hoverAccountUser(WebDriver webdriver) throws InterruptedException {

        Actions action = new Actions(webdriver);

        action.moveToElement(user_menu).perform();
        Thread.sleep(2000);

        WebElement subElem = webdriver.findElement(By.xpath("//*[@id=\"account_dropdown\"]/li[3]/a"));

        action.moveToElement(subElem);
        action.click();
        action.perform();
    }


}