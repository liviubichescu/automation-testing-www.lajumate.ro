package Lajumate.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class AnunturileMelePage extends PageObject {

    // verificam daca am ajuns pe pagina cu anunturile mele
    public List<String> check_anunturile_mele_page() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map(element -> element.getAttribute("class"))
                .collect(Collectors.toList());
    }


    // facem click pe "anunturi in moderare"
    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/div[1]/ul/li[3]/a")
    private WebElementFacade anunturi_moderare;
    public void click_anunturi_in_moderare() {
        anunturi_moderare.click();
    }

    // verificam daca s-a facut click eficient si daca avem pagina cu anunturi in moderare
    public List<String> check_anunturi_moderare_loading() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("h1")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // verificam daca anuntul este present in sectiunea moderare
    public List<String> check_if_add_is_in_moderare() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("h2")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }


    /********************************************* partea de stergere anunt ************************/


    // facem click pe "anunturi active"
    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/div[1]/ul/li[1]/a")
    private WebElementFacade anunturi_active;

    public void click_anunturi_active() {
        anunturi_active.click();
    }

    // verificam daca anuntul este present in sectiunea moderare
    public List<String> check_if_anunturi_active_loaded() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("h1")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // verificam daca anuntul este present in sectiunea moderare
    public List<String> check_if_add_is_in_anunturi_active() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("h2")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // select checkbox for delete
    @FindBy(xpath = "//*[@id=\"record-9101950\"]/div[1]/div/label")
    private WebElementFacade checkBox_for_delete;
    public void click_checkBox_for_delete() {
        checkBox_for_delete.click();
    }

    // select checkbox for delete
    @FindBy(xpath = "//*[@id=\"record-9101950\"]/div[2]/div[2]/a[2]")
    private WebElementFacade dezactiveaza;
    public void click_dezactiveaza() {
        dezactiveaza.click();
    }

    // click motivul vanzarii
    @FindBy(xpath = "//*[@id=\"submit_reason\"]/div/div[1]/label[4]/div/label")
    private WebElementFacade delete_reason;
    public void click_delete_reason() {
        delete_reason.click();
    }

    // click dezactiveaza anunt in motivul dezactivarii pop-up
    @FindBy(xpath = "//*[@id=\"submit_reason_btn\"]")
    private WebElementFacade deactivate_add;

    public void submit_deactivate_popUp_reason() {
        deactivate_add.click();
    }

    /*********************** check if add vas deactivated ******************/

    // verificam daca anuntul a fost dezactivat si nu este present in anunturile active
    public List<String> check_if_add_not_present_in_active_adds() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("h2")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // facem click pe "anunturi dezactivate"
    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/div[1]/ul/li[4]/a/span")
    private WebElementFacade anunturi_dezactivate;
    public void click_anunturi_dezactivate() {
        anunturi_dezactivate.click();
    }

    // verificam daca suntem pe pagina cu anunturi dezactivate
    public List<String> check_anunturi_dezactivate_page() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("h1")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // verificam daca anuntul a fost dezactivat si este present in anunturile dezactivate
    public List<String> check_if_add_is_present_in_deactivated() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("h2")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }


}