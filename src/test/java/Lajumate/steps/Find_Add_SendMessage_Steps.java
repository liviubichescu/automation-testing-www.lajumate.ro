package Lajumate.steps;

import Lajumate.pages.Find_Add_SendMessage_Page;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class Find_Add_SendMessage_Steps {

    private Find_Add_SendMessage_Page find_Add_sendMessage_page;

    @Step
    public void search_add(String search_title){
        find_Add_sendMessage_page.search(search_title);
    }

    @Step
    public void click_cauta(){
        find_Add_sendMessage_page.click_cauta_button();
    }

    @Step
    public void check_cautare_efectuata_cu_succes(String message) throws InterruptedException {
        assertThat(find_Add_sendMessage_page.getTextCautareEfectuataCuSucces(), hasItem(containsString(message)));
        Thread.sleep(1000);
    }

    @Step
    public void click_anunt_gasit_step(String titluAnunt) throws InterruptedException {
        find_Add_sendMessage_page.click_anunt_gasit(titluAnunt);
    }

    @Step
    public void check_anunt_incarcat_cu_succes(String message) {
        assertThat(find_Add_sendMessage_page.check_for_proper_add_load(), hasItem(containsString(message)));
    }

    @Step
    public void click_trimiteMesaj(){
        find_Add_sendMessage_page.click_trimite_mesaj();
    }

    @Step
    public void write_message(String message) throws InterruptedException {
        find_Add_sendMessage_page.write_message(message);
    }
    @Step
    public void click_send_msg(){
        find_Add_sendMessage_page.click_trimite_msg();
    }

    @Step
    public void click_anvelope_message() throws InterruptedException {
        find_Add_sendMessage_page.click_anvelope();
    }

    @Step
    public void check_message_page(String mesaje_primite, String mesaje_trimise) {
        assertThat(find_Add_sendMessage_page.check_for_proper_add_load(), hasItem(containsString(mesaje_primite)));
        assertThat(find_Add_sendMessage_page.check_for_proper_add_load(), hasItem(containsString(mesaje_trimise)));
    }

    @Step
    public void click_mesaje_trimise() {
        find_Add_sendMessage_page.click_mesaje_trimis();
    }


    @Step
    public void checkText_mesaje_trimise(String text_mesaje_trimise) {
        assertThat(find_Add_sendMessage_page.checkText_in_mesaje_trimise(), hasItem(containsString(text_mesaje_trimise)));
    }

    @Step
    public void select_mesaj_in_mesaje_trimise(String textTitle) throws InterruptedException {
        find_Add_sendMessage_page.selecteaza_mesaj_in_mesaje_trimise(textTitle);
    }

    @Step
    public void check_if_mesajul_este_in_mesaje_trimise(String text_mesaje_trimis) {
        assertThat(find_Add_sendMessage_page.checkText_if_mesajul_este_in_mesaje_trimise(), hasItem(containsString(text_mesaje_trimis)));
    }

}