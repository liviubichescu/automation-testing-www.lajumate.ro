package Lajumate.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;


public class LogOutPage extends PageObject {

    @FindBy(id="account_menu_link")
    private WebElementFacade user_menu;
    public void hoverUserAndLogout(WebDriver webdriver) throws InterruptedException {

        Actions action = new Actions(webdriver);

        action.moveToElement(user_menu).perform();
        Thread.sleep(2000);

        WebElement logout = webdriver.findElement(By.className("user_logout"));

        action.moveToElement(logout);
        action.click();
        action.perform();
        Thread.sleep(2000);

    }

    // verificam daca logout-ul s-a facut cu succes si am ajuns pe pagina de home
    public List<String> check_if_logout_is_succes() {
        WebElementFacade definitionList = find(By.id("menu"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }


}