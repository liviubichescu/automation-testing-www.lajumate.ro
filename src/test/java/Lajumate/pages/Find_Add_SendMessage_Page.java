package Lajumate.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

// pagina pentru a verifica daca am trecut de pagina de login cu succes
public class Find_Add_SendMessage_Page extends PageObject {

    // introducem titlul anuntului pe care dorim sa il cautam
    @FindBy(id = "search")
    private WebElementFacade search;

    public void search(String title) {
        search.type(title);
    }

    // facem click pe cauta
    @FindBy(xpath = "//*[@id=\"hold_together\"]/input")
    private WebElementFacade cauta_button;

    public void click_cauta_button() {
        cauta_button.click();
    }
    // verificam daca, cautarea anunturilor cu titlul respectiv s-a efectuat cu succes
    public List<String> getTextCautareEfectuataCuSucces() {
        WebElementFacade definitionList = find(By.id("tag_holder"));
        return definitionList.findElements(By.tagName("div")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // cautam dinamic in lista de anunturi, anuntul nostru si dam click pe el
    @FindBy(id = "list_cart_holder")
    private WebElementFacade container_adds;
    public void click_anunt_gasit(String textTitlu) throws InterruptedException {
        selectAnuntDupaText(container_adds, textTitlu);
    }

    // metoda care permite sa selectezi un element din lista
    public void selectAnuntDupaText(WebElementFacade el, String value) {
        List<WebElement> list = el.findElements(By.tagName("a"));
        for (int i = 0; i < list.size(); i++) {
            WebElement text = list.get(i).findElement(By.cssSelector("[id^=title_ad]"));
            String dir = text.getText();
            list.get(i).click();
            break;

        }
    }

    // verificam daca s-a deschis pagina cu anuntul dorit
    public List<String> check_for_proper_add_load() {
        WebElementFacade definitionList = find(By.id("container"));
        return definitionList.findElements(By.tagName("span")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // facem click pe trimitere mesaj
    @FindBy(id = "send_msg")
    private WebElementFacade trimite_mesaj_button;
    public void click_trimite_mesaj() {
        trimite_mesaj_button.click();
    }

    @FindBy(name = "message")
    private WebElementFacade message;
    public void write_message(String mesaj) throws InterruptedException {
        message.type(mesaj);
        Thread.sleep(5000);
    }

    // facem click pe trimite_mesaj
    @FindBy(id = "msg_send")
    private WebElementFacade msg_send;

    public void click_trimite_msg() {
        msg_send.click();
    }

    // facem click pe simbolul plic
    @FindBy(id = "to_messages")
    private WebElementFacade plic;

    public void click_anvelope() throws InterruptedException {
        plic.click();
        Thread.sleep(2000);
    }

    // verificam daca am ajuns pe pagina cu mesaje
    public List<String> check_message_page() {
        WebElementFacade definitionList = find(By.id("container"));
        return definitionList.findElements(By.tagName("span")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // facem click mesaje trimise
    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/div[1]/ul/li[2]/a")
    private WebElementFacade sent_msg;

    public void click_mesaje_trimis() {
        sent_msg.click();
    }

    // verificam daca suntem pe mesaje trimise
    public List<String> checkText_in_mesaje_trimise() {
        WebElementFacade definitionList = find(By.id("list_account_items"));
        return definitionList.findElements(By.tagName("h1")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    // cautam dinamic in lista de titluri, titlul anuntului nostru si dam click pe el
    @FindBy(id = "list_account_items")
    private WebElementFacade account_items;
    public void selecteaza_mesaj_in_mesaje_trimise(String textTitlu) throws InterruptedException {
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
    public List<String> checkText_if_mesajul_este_in_mesaje_trimise() {
        WebElementFacade definitionList = find(By.id("conversation_height"));
        return definitionList.findElements(By.tagName("p")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

}