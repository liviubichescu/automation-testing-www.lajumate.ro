package Lajumate.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

// pagina pentru a verifica daca am trecut de pagina de login cu succes
public class Check_if_message_received_Page extends PageObject {

    // facem click pe simbolul plic
    @FindBy(id = "to_messages")
    private WebElementFacade plic;

    public void click_anvelope() throws InterruptedException {
        plic.click();
        Thread.sleep(2000);
    }


    // verificam daca s-a deschis pagina cu anuntul dorit
    public List<String> check_for_proper_add_load() {
        WebElementFacade definitionList = find(By.id("container"));
        return definitionList.findElements(By.tagName("span")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // verificam daca am ajuns pe pagina cu mesaje
    public List<String> check_message_page() {
        WebElementFacade definitionList = find(By.id("container"));
        return definitionList.findElements(By.tagName("span")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // facem click pe mesaje primite
    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/div[1]/ul/li[1]/a")
    private WebElementFacade received_msg;
    public void click_mesaje_primite() {
        received_msg.click();
    }

    // verificam daca suntem pe mesaje trimise
    public List<String> checkText_in_mesaje_primite() {
        WebElementFacade definitionList = find(By.id("list_account_items"));
        return definitionList.findElements(By.tagName("h1")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // cautam dinamic in lista de titluri, titlul anuntului nostru si dam click pe el
    @FindBy(id = "list_account_items")
    private WebElementFacade account_items;
    public void selecteaza_mesaj_in_mesaje_primite(String textTitlu) throws InterruptedException {
        selectDirectoryByValue(account_items, textTitlu);
    }
    // metoda cu care selectam un anunt din lista de anunturi
    public void selectDirectoryByValue(WebElementFacade el, String value) throws InterruptedException {
        List<WebElement> list = el.findElements(By.tagName("a"));

        for (int i = 0; i < list.size(); i++) {
            String dir = list.get(i).getText();
            if (dir.equalsIgnoreCase(value)) {
                Thread.sleep(2000);
                list.get(i).click();
                break;
            }
        }
    }

    // verifica daca mesajul este in mesaje trimise
    public List<String> checkText_if_mesajul_este_in_mesaje_primite() {
        WebElementFacade definitionList = find(By.id("conversation_height"));
        return definitionList.findElements(By.tagName("p")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }





}