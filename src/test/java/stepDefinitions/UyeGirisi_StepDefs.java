package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import pages.UyeGirisi_page;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.switchToWindow;

public class UyeGirisi_StepDefs {

    UyeGirisi_page uyeGirisi_page = new UyeGirisi_page();

    SearchContext shadowRootElement;
    WebElement hiddenElement;

    @When("Uye Girisi butonu tiklar")
    public void uyeGirisiButonuTiklar() {
        uyeGirisi_page.uyeGirisiButton.click();
    }

    @Then("Kullanici Adi, Sifre textboxlarının goruntulendigini dogrular")
    public void kullaniciAdiSifreTextboxlarınınGoruntulendiginiDogrular() {
        switchToWindow(1);
        assertTrue("Kullanıcı Adı textbox is not visible", uyeGirisi_page.userNameTextBox.isEnabled());
        assertTrue("Sifre Textbox is not visible", uyeGirisi_page.passwordTextBox.isEnabled());
    }

    @Then("Giris Yap ve Sifremi Unuttum buttonlarının goruntulendigini dogrular")
    public void girisYapVeSifremiUnuttumButtonlarınınGoruntulendiginiDogrular() {
        assertTrue("Giris Yap button is not visible", uyeGirisi_page.girisYapButton.isDisplayed());
        assertTrue("Sifremi Unuttum button is not visible", uyeGirisi_page.sifremiUnuttumButton.isDisplayed());

    }


}
