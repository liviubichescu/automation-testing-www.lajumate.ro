package Lajumate.steps;

import Lajumate.pages.Check_if_message_received_Page;
import Lajumate.pages.Find_Add_SendMessage_Page;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class Check_if_message_received_Steps {

    private Check_if_message_received_Page check_if_message_received_page;

    @Step
    public void click_anvelope_message() throws InterruptedException {
        check_if_message_received_page.click_anvelope();
    }

    @Step
    public void check_message_page(String mesaje_primite, String mesaje_trimise) {
        assertThat(check_if_message_received_page.check_for_proper_add_load(), hasItem(containsString(mesaje_primite)));
        assertThat(check_if_message_received_page.check_for_proper_add_load(), hasItem(containsString(mesaje_trimise)));
    }

    @Step
    public void click_mesaje_primite() {
        check_if_message_received_page.click_mesaje_primite();
    }


    @Step
    public void checkText_mesaje_primite(String text_mesaje_primite) {
        assertThat(check_if_message_received_page.checkText_in_mesaje_primite(), hasItem(containsString(text_mesaje_primite)));
    }

    @Step
    public void select_mesaj_in_mesaje_primite(String textTitle) throws InterruptedException {
        check_if_message_received_page.selecteaza_mesaj_in_mesaje_primite(textTitle);
    }

    @Step
    public void check_if_mesajul_este_in_mesaje_primite(String text_mesaje_primit) {
        assertThat(check_if_message_received_page.checkText_if_mesajul_este_in_mesaje_primite(), hasItem(containsString(text_mesaje_primit)));
    }

}