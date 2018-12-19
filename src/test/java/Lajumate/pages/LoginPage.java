package Lajumate.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;


@DefaultUrl("https://lajumate.ro")
public class LoginPage extends PageObject {

    @FindBy(id="login_action") // ne uitam in pagina cu inspect element la "nume" si il identificam
    private WebElementFacade autentificare;
    public void click_autentificare() {
        autentificare.click();
    }

    @FindBy(name="email")
    private WebElementFacade user;
    public void enters_username(String username) {
        user.type(username);
    }

    @FindBy(name="password")
    private WebElementFacade password;
    public void enters_password(String pass) {
        password.type(pass);
    }

    // click pe butonul de autentificare
    @FindBy(id="login_form")
    private WebElementFacade autentificareButton;
    public void click_login() {
        click_autentificare_by_value(autentificareButton,"value","Autentificare");
    }

    // metoda care permite sa selectezi un element din lista dinamic
    public void click_autentificare_by_value(WebElementFacade el, String attribute, String value) {
        List<WebElement> list  = el.findElements(By.tagName("input"));
        for (int i=0; i<list.size(); i++){
            String dir = list.get(i).getAttribute(attribute);
            if (dir.equalsIgnoreCase(value)){
                list.get(i).click();
                break;
            }
        }
    }


    public List<String> should_be_in_current_directory() {
        WebElementFacade definitionList = find(By.tagName("ul"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }

    public List<String> alert_message_for_account() {
        WebElementFacade definitionList = find(By.id("login_form"));
        return definitionList.findElements(By.className("messages")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }
}